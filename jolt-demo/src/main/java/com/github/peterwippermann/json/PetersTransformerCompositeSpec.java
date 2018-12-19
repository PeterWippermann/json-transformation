package com.github.peterwippermann.json;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.bazaarvoice.jolt.common.pathelement.LiteralPathElement;
import com.bazaarvoice.jolt.common.pathelement.StarAllPathElement;
import com.bazaarvoice.jolt.common.pathelement.StarPathElement;
import com.bazaarvoice.jolt.exception.SpecException;

public class PetersTransformerCompositeSpec extends PetersTransformerSpec {

	private final List<PetersTransformerSpec> allChildNodes;

	@SuppressWarnings("unchecked")
	public PetersTransformerCompositeSpec(String rawKey, Map<String, Object> spec) {
		super(rawKey);
		List<PetersTransformerSpec> all = new ArrayList<>();

		for (String rawLhsStr : spec.keySet()) {
			Object rawRhs = spec.get(rawLhsStr);
			String[] keyStrings = rawLhsStr.split("\\|");
			for (String keyString : keyStrings) {
				PetersTransformerSpec childSpec;
				if (rawRhs instanceof Map) {
					childSpec = new PetersTransformerCompositeSpec(keyString, (Map<String, Object>) rawRhs);
				} else // if (rawRhs instanceof String && ((String)rawRhs).trim().length() == 0)
				{
					childSpec = new PetersTransformerLeafSpec(keyString, (String) rawRhs);
				}
//                else{
//                    throw new SpecException("Invalid Removr spec RHS. Should be an empty string or Map");
//                }
				all.add(childSpec);
			}
		}
		allChildNodes = Collections.unmodifiableList(all);
	}

	@Override
	public List<String> applyToMap(Map<String, Object> inputMap) {

		if (pathElement instanceof LiteralPathElement) {
			Object subInput = inputMap.get(pathElement.getRawKey());
			processChildren(allChildNodes, subInput);
		} else if (pathElement instanceof StarPathElement) {

			StarPathElement star = (StarPathElement) pathElement;

			// Compare my pathElement with each key from the input.
			// If it matches, recursively call process the child nodes.
			for (Map.Entry<String, Object> entry : inputMap.entrySet()) {

				if (star.stringMatch(entry.getKey())) {
					processChildren(allChildNodes, entry.getValue());
				}
			}
		}

		// Composite Nodes always return an empty list, as they dont actually remove
		// anything.
		return Collections.emptyList();
	}

	@Override
	public List<Integer> applyToList(List<Object> inputList) {

		// IF the input is a List, the only thing that will match is a Literal or a "*"
		if (pathElement instanceof LiteralPathElement) {

			Integer pathElementInt = getNonNegativeIntegerFromLiteralPathElement();

			if (pathElementInt != null && pathElementInt < inputList.size()) {
				Object subObj = inputList.get(pathElementInt);
				processChildren(allChildNodes, subObj);
			}
		} else if (pathElement instanceof StarAllPathElement) {
			for (Object entry : inputList) {
				processChildren(allChildNodes, entry);
			}
		}

		// Composite Nodes always return an empty list, as they dont actually remove
		// anything.
		return Collections.emptyList();
	}

	/**
	 * Call our child nodes, build up the set of keys or indices to actually remove,
	 * and then remove them.
	 */
	private void processChildren(List<PetersTransformerSpec> children, Object subInput) {

		if (subInput != null) {

			if (subInput instanceof List) {

				@SuppressWarnings("unchecked")
				List<Object> subList = (List<Object>) subInput;
				Set<Integer> indiciesToRemove = new HashSet<>();

				// build a list of all indicies to remove
				for (PetersTransformerSpec childSpec : children) {
					indiciesToRemove.addAll(childSpec.applyToList(subList));
				}

				List<Integer> uniqueIndiciesToRemove = new ArrayList<>(indiciesToRemove);
				// Sort the list from Biggest to Smallest, so that when we remove items from the
				// input
				// list we don't muck up the order.
				// Aka removing 0 _then_ 3 would be bad, because we would have actually removed
				// 0 and 4 from the "original" list.
				Collections.sort(uniqueIndiciesToRemove, new Comparator<Integer>() {
					@Override
					public int compare(Integer o1, Integer o2) {
						return o2.compareTo(o1);
					}
				});

				for (int index : uniqueIndiciesToRemove) {
					subList.remove(index);
				}
			} else if (subInput instanceof Map) {

				@SuppressWarnings("unchecked")
				Map<String, Object> subInputMap = (Map<String, Object>) subInput;

				List<String> keysToRemove = new LinkedList<>();

				for (PetersTransformerSpec childSpec : children) {
					keysToRemove.addAll(childSpec.applyToMap(subInputMap));
				}

				subInputMap.keySet().removeAll(keysToRemove);
			}
		}
	}
}
