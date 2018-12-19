package com.github.peterwippermann.json;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.bazaarvoice.jolt.common.pathelement.LiteralPathElement;
import com.bazaarvoice.jolt.common.pathelement.StarAllPathElement;
import com.bazaarvoice.jolt.common.pathelement.StarPathElement;

public class PetersTransformerLeafSpec extends PetersTransformerSpec {

	private static final String WKN_ZU_ISIN_TRANSFORMATION_KEY = "WKN-zu-ISIN";
	private String rhs;

	public PetersTransformerLeafSpec(String rawKey, String rhs) {
		super(rawKey);
		this.rhs = rhs;
	}

	/**
	 * Build a list of keys to remove from the input map, using the pathElement from
	 * the Spec.
	 *
	 * @param inputMap : Input map from which the spec key needs to be removed.
	 */
	@Override
	public List<String> applyToMap(Map<String, Object> inputMap) {
		if (inputMap == null) {
			return null;
		}

		// List<String> keysToBeRemoved = new LinkedList<>();

		if (pathElement instanceof LiteralPathElement) {

			// if we are a literal, check to see if we match
			if (inputMap.containsKey(pathElement.getRawKey())) {
				if (rhs.equals(WKN_ZU_ISIN_TRANSFORMATION_KEY)) {
					String value = (String) inputMap.get(pathElement.getRawKey());
					inputMap.put(pathElement.getRawKey(), "ISIN" + value + value);
				} else {
					throw new RuntimeException("Unknown transformation: " + rhs);
				}
				// keysToBeRemoved.add( pathElement.getRawKey() );
			}
		} else if (pathElement instanceof StarPathElement) {

			StarPathElement star = (StarPathElement) pathElement;

			// if we are a wildcard, check each input key to see if it matches us
			for (String key : inputMap.keySet()) {

				if (star.stringMatch(key)) {
//                    keysToBeRemoved.add( key );
					inputMap.put(key, "blzub");
				}
			}
		}

		return Collections.emptyList(); // Don't delete any keys.
	}

	/**
	 * @param inputList : Input List from which the spec key needs to be removed.
	 */
	@Override
	public List<Integer> applyToList(List<Object> inputList) {
		if (inputList == null) {
			return null;
		}

		if (pathElement instanceof LiteralPathElement) {

			Integer pathElementInt = getNonNegativeIntegerFromLiteralPathElement();

			if (pathElementInt != null && pathElementInt < inputList.size()) {
				return Collections.singletonList(pathElementInt);
			}
		} else if (pathElement instanceof StarAllPathElement) {

			// To be clear, this is kinda silly.
			// If you just wanted to remove the whole list, you could have just
			// directly removed it, instead of stepping into it and using the "*".
			List<Integer> toReturn = new ArrayList<>(inputList.size());
			for (int index = 0; index < inputList.size(); index++) {
				toReturn.add(index);
			}

			return toReturn;
		}
		// else the pathElement is some other kind which is not supported when running
		// against arrays, aka "tuna*" makes no sense against a list.

		return Collections.emptyList();
	}
}
