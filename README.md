# json-transformation
This repo evaluates two alternative approaches to transform a JSON document into another JSON format.
## XSLT - A customised SAX parser with standard XSLT transformation.  
First a JSON parser has been generated with ANTLR. This one is used by a customised SAX reader to feed a SAX parser. So the JSON is treated as if it would be XML - although transformation to intermediate XML never happens, which should save us from some performance penalty. Then XSLT transformation is applied, which is a standard feature of the SAX parser. Optional XSD validation has been disabled. At the end the customised SAX writer generates valid JSON again.

Custom transformation for selected values implemented in Java has not been evaluated. In conclusion, XSLT is certainly feature-complete, but is also very complex. Regarding my requirements, XSLT is not my preferred approach but can certainly be used as a fallback.

## JOLT - A ready to use JSON parser written in Java
There are many parsers available in JavaScript but only few in Java. Although I've been sceptical at first, JOLT seems to be feature-complete - at least regarding my requirements.
Documentation is available in JavaDoc only and sometimes appears a bit strange to me. Implementation of a custom transformer was successful but also a bit tedious. The short notation of the transformation 'spec' is definitely a plus.
