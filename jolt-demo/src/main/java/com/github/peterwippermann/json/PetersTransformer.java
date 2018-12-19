package com.github.peterwippermann.json;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import com.bazaarvoice.jolt.Removr;
import com.bazaarvoice.jolt.SpecDriven;
import com.bazaarvoice.jolt.Transform;
import com.bazaarvoice.jolt.exception.SpecException;

/**
 * Exemplary implementation of a transformer. 
 * 
 * Copied from {@link Removr}
 */
public class PetersTransformer implements SpecDriven, Transform {

	private static final String ROOT_KEY = "root";
	private final PetersTransformerCompositeSpec rootSpec;

	@SuppressWarnings("unchecked")
	@Inject
	public PetersTransformer(Object spec) {
		if (spec == null) {
			throw new SpecException("DiamondCaTransformer expected a spec of Map type, got 'null'.");
		}
		if (!(spec instanceof Map)) {
			throw new SpecException(
					"DiamondCaTransformer expected a spec of Map type, got " + spec.getClass().getSimpleName());
		}

		rootSpec = new PetersTransformerCompositeSpec(ROOT_KEY, (Map<String, Object>) spec);
	}

	/**
	 * Recursively removes data from the input JSON.
	 *
	 * @param input the JSON object to transform in plain vanilla Jackson
	 *              Map<String, Object> style
	 */
	@Override
	public Object transform(Object input) {
		// Wrap the input in a map to fool the CompositeSpec to recurse itself.
		Map<String, Object> wrappedMap = new HashMap<>();
		wrappedMap.put(ROOT_KEY, input);
		rootSpec.applyToMap(wrappedMap);
		return input;
	}
}
