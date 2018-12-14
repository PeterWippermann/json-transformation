// $ANTLR 3.5.2 .\\grammar\\JSON.g 2018-12-14 23:44:53

// AUTOGENERATED BY ANTLR!!! DO NOT MODIFY!!!

//--------------------------------------
// Peter Wippermann
//
//--------------------------------------
package com.github.peterwippermann.xslt4json;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.tree.*;


@SuppressWarnings("all")
public class JSONParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "Boolean", "Digit", "Dot", "Double", 
		"EscapeSequence", "Exp", "Frac", "HexDigit", "Int", "Integer", "NULL", 
		"String", "StringChar", "UnicodeChar", "WhiteSpace", "XML_ATTRIBUTE", 
		"XML_ELEMENT", "','", "':'", "'['", "']'", "'{'", "'}'"
	};
	public static final int EOF=-1;
	public static final int T__21=21;
	public static final int T__22=22;
	public static final int T__23=23;
	public static final int T__24=24;
	public static final int T__25=25;
	public static final int T__26=26;
	public static final int Boolean=4;
	public static final int Digit=5;
	public static final int Dot=6;
	public static final int Double=7;
	public static final int EscapeSequence=8;
	public static final int Exp=9;
	public static final int Frac=10;
	public static final int HexDigit=11;
	public static final int Int=12;
	public static final int Integer=13;
	public static final int NULL=14;
	public static final int String=15;
	public static final int StringChar=16;
	public static final int UnicodeChar=17;
	public static final int WhiteSpace=18;
	public static final int XML_ATTRIBUTE=19;
	public static final int XML_ELEMENT=20;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public JSONParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public JSONParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	protected TreeAdaptor adaptor = new CommonTreeAdaptor();

	public void setTreeAdaptor(TreeAdaptor adaptor) {
		this.adaptor = adaptor;
	}
	public TreeAdaptor getTreeAdaptor() {
		return adaptor;
	}
	@Override public String[] getTokenNames() { return JSONParser.tokenNames; }
	@Override public String getGrammarFileName() { return ".\\grammar\\JSON.g"; }


	public static class json_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "json"
	// .\\grammar\\JSON.g:98:1: json : value ;
	public final JSONParser.json_return json() throws RecognitionException {
		JSONParser.json_return retval = new JSONParser.json_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope value1 =null;


		try {
			// .\\grammar\\JSON.g:99:2: ( value )
			// .\\grammar\\JSON.g:99:4: value
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_value_in_json411);
			value1=value();
			state._fsp--;

			adaptor.addChild(root_0, value1.getTree());

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "json"


	public static class object_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "object"
	// .\\grammar\\JSON.g:102:1: object : '{' ( field ( ',' field )* )? '}' -> ^( XML_ELEMENT[\"object\"] ( field )* ) ;
	public final JSONParser.object_return object() throws RecognitionException {
		JSONParser.object_return retval = new JSONParser.object_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal2=null;
		Token char_literal4=null;
		Token char_literal6=null;
		ParserRuleReturnScope field3 =null;
		ParserRuleReturnScope field5 =null;

		Object char_literal2_tree=null;
		Object char_literal4_tree=null;
		Object char_literal6_tree=null;
		RewriteRuleTokenStream stream_25=new RewriteRuleTokenStream(adaptor,"token 25");
		RewriteRuleTokenStream stream_26=new RewriteRuleTokenStream(adaptor,"token 26");
		RewriteRuleTokenStream stream_21=new RewriteRuleTokenStream(adaptor,"token 21");
		RewriteRuleSubtreeStream stream_field=new RewriteRuleSubtreeStream(adaptor,"rule field");

		try {
			// .\\grammar\\JSON.g:103:2: ( '{' ( field ( ',' field )* )? '}' -> ^( XML_ELEMENT[\"object\"] ( field )* ) )
			// .\\grammar\\JSON.g:103:4: '{' ( field ( ',' field )* )? '}'
			{
			char_literal2=(Token)match(input,25,FOLLOW_25_in_object422);  
			stream_25.add(char_literal2);

			// .\\grammar\\JSON.g:103:8: ( field ( ',' field )* )?
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==String) ) {
				alt2=1;
			}
			switch (alt2) {
				case 1 :
					// .\\grammar\\JSON.g:103:9: field ( ',' field )*
					{
					pushFollow(FOLLOW_field_in_object425);
					field3=field();
					state._fsp--;

					stream_field.add(field3.getTree());
					// .\\grammar\\JSON.g:103:15: ( ',' field )*
					loop1:
					while (true) {
						int alt1=2;
						int LA1_0 = input.LA(1);
						if ( (LA1_0==21) ) {
							alt1=1;
						}

						switch (alt1) {
						case 1 :
							// .\\grammar\\JSON.g:103:16: ',' field
							{
							char_literal4=(Token)match(input,21,FOLLOW_21_in_object428);  
							stream_21.add(char_literal4);

							pushFollow(FOLLOW_field_in_object430);
							field5=field();
							state._fsp--;

							stream_field.add(field5.getTree());
							}
							break;

						default :
							break loop1;
						}
					}

					}
					break;

			}

			char_literal6=(Token)match(input,26,FOLLOW_26_in_object436);  
			stream_26.add(char_literal6);

			// AST REWRITE
			// elements: field
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 104:4: -> ^( XML_ELEMENT[\"object\"] ( field )* )
			{
				// .\\grammar\\JSON.g:104:7: ^( XML_ELEMENT[\"object\"] ( field )* )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(XML_ELEMENT, "object"), root_1);
				// .\\grammar\\JSON.g:104:31: ( field )*
				while ( stream_field.hasNext() ) {
					adaptor.addChild(root_1, stream_field.nextTree());
				}
				stream_field.reset();

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "object"


	public static class field_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "field"
	// .\\grammar\\JSON.g:107:1: field : String ':' value -> ^( XML_ELEMENT[\"field\"] ^( XML_ATTRIBUTE[\"name\"] String ) value ) ;
	public final JSONParser.field_return field() throws RecognitionException {
		JSONParser.field_return retval = new JSONParser.field_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token String7=null;
		Token char_literal8=null;
		ParserRuleReturnScope value9 =null;

		Object String7_tree=null;
		Object char_literal8_tree=null;
		RewriteRuleTokenStream stream_22=new RewriteRuleTokenStream(adaptor,"token 22");
		RewriteRuleTokenStream stream_String=new RewriteRuleTokenStream(adaptor,"token String");
		RewriteRuleSubtreeStream stream_value=new RewriteRuleSubtreeStream(adaptor,"rule value");

		try {
			// .\\grammar\\JSON.g:108:2: ( String ':' value -> ^( XML_ELEMENT[\"field\"] ^( XML_ATTRIBUTE[\"name\"] String ) value ) )
			// .\\grammar\\JSON.g:108:4: String ':' value
			{
			String7=(Token)match(input,String,FOLLOW_String_in_field461);  
			stream_String.add(String7);

			char_literal8=(Token)match(input,22,FOLLOW_22_in_field463);  
			stream_22.add(char_literal8);

			pushFollow(FOLLOW_value_in_field465);
			value9=value();
			state._fsp--;

			stream_value.add(value9.getTree());
			// AST REWRITE
			// elements: String, value
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 109:4: -> ^( XML_ELEMENT[\"field\"] ^( XML_ATTRIBUTE[\"name\"] String ) value )
			{
				// .\\grammar\\JSON.g:109:7: ^( XML_ELEMENT[\"field\"] ^( XML_ATTRIBUTE[\"name\"] String ) value )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(XML_ELEMENT, "field"), root_1);
				// .\\grammar\\JSON.g:109:30: ^( XML_ATTRIBUTE[\"name\"] String )
				{
				Object root_2 = (Object)adaptor.nil();
				root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(XML_ATTRIBUTE, "name"), root_2);
				adaptor.addChild(root_2, stream_String.nextNode());
				adaptor.addChild(root_1, root_2);
				}

				adaptor.addChild(root_1, stream_value.nextTree());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "field"


	public static class array_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "array"
	// .\\grammar\\JSON.g:112:1: array : '[' value ( ',' value )* ']' -> ^( XML_ELEMENT[\"array\"] ( value )+ ) ;
	public final JSONParser.array_return array() throws RecognitionException {
		JSONParser.array_return retval = new JSONParser.array_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal10=null;
		Token char_literal12=null;
		Token char_literal14=null;
		ParserRuleReturnScope value11 =null;
		ParserRuleReturnScope value13 =null;

		Object char_literal10_tree=null;
		Object char_literal12_tree=null;
		Object char_literal14_tree=null;
		RewriteRuleTokenStream stream_23=new RewriteRuleTokenStream(adaptor,"token 23");
		RewriteRuleTokenStream stream_24=new RewriteRuleTokenStream(adaptor,"token 24");
		RewriteRuleTokenStream stream_21=new RewriteRuleTokenStream(adaptor,"token 21");
		RewriteRuleSubtreeStream stream_value=new RewriteRuleSubtreeStream(adaptor,"rule value");

		try {
			// .\\grammar\\JSON.g:113:2: ( '[' value ( ',' value )* ']' -> ^( XML_ELEMENT[\"array\"] ( value )+ ) )
			// .\\grammar\\JSON.g:113:4: '[' value ( ',' value )* ']'
			{
			char_literal10=(Token)match(input,23,FOLLOW_23_in_array497);  
			stream_23.add(char_literal10);

			pushFollow(FOLLOW_value_in_array499);
			value11=value();
			state._fsp--;

			stream_value.add(value11.getTree());
			// .\\grammar\\JSON.g:113:14: ( ',' value )*
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( (LA3_0==21) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// .\\grammar\\JSON.g:113:15: ',' value
					{
					char_literal12=(Token)match(input,21,FOLLOW_21_in_array502);  
					stream_21.add(char_literal12);

					pushFollow(FOLLOW_value_in_array504);
					value13=value();
					state._fsp--;

					stream_value.add(value13.getTree());
					}
					break;

				default :
					break loop3;
				}
			}

			char_literal14=(Token)match(input,24,FOLLOW_24_in_array508);  
			stream_24.add(char_literal14);

			// AST REWRITE
			// elements: value
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 114:4: -> ^( XML_ELEMENT[\"array\"] ( value )+ )
			{
				// .\\grammar\\JSON.g:114:7: ^( XML_ELEMENT[\"array\"] ( value )+ )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(XML_ELEMENT, "array"), root_1);
				if ( !(stream_value.hasNext()) ) {
					throw new RewriteEarlyExitException();
				}
				while ( stream_value.hasNext() ) {
					adaptor.addChild(root_1, stream_value.nextTree());
				}
				stream_value.reset();

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "array"


	public static class value_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "value"
	// .\\grammar\\JSON.g:118:1: value : ( String -> ^( XML_ELEMENT[\"string\"] String ) | Integer -> ^( XML_ELEMENT[\"integer\"] Integer ) | Double -> ^( XML_ELEMENT[\"double\"] Double ) | Boolean -> ^( XML_ELEMENT[\"boolean\"] Boolean ) | object | array | NULL );
	public final JSONParser.value_return value() throws RecognitionException {
		JSONParser.value_return retval = new JSONParser.value_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token String15=null;
		Token Integer16=null;
		Token Double17=null;
		Token Boolean18=null;
		Token NULL21=null;
		ParserRuleReturnScope object19 =null;
		ParserRuleReturnScope array20 =null;

		Object String15_tree=null;
		Object Integer16_tree=null;
		Object Double17_tree=null;
		Object Boolean18_tree=null;
		Object NULL21_tree=null;
		RewriteRuleTokenStream stream_Integer=new RewriteRuleTokenStream(adaptor,"token Integer");
		RewriteRuleTokenStream stream_String=new RewriteRuleTokenStream(adaptor,"token String");
		RewriteRuleTokenStream stream_Boolean=new RewriteRuleTokenStream(adaptor,"token Boolean");
		RewriteRuleTokenStream stream_Double=new RewriteRuleTokenStream(adaptor,"token Double");

		try {
			// .\\grammar\\JSON.g:119:2: ( String -> ^( XML_ELEMENT[\"string\"] String ) | Integer -> ^( XML_ELEMENT[\"integer\"] Integer ) | Double -> ^( XML_ELEMENT[\"double\"] Double ) | Boolean -> ^( XML_ELEMENT[\"boolean\"] Boolean ) | object | array | NULL )
			int alt4=7;
			switch ( input.LA(1) ) {
			case String:
				{
				alt4=1;
				}
				break;
			case Integer:
				{
				alt4=2;
				}
				break;
			case Double:
				{
				alt4=3;
				}
				break;
			case Boolean:
				{
				alt4=4;
				}
				break;
			case 25:
				{
				alt4=5;
				}
				break;
			case 23:
				{
				alt4=6;
				}
				break;
			case NULL:
				{
				alt4=7;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 4, 0, input);
				throw nvae;
			}
			switch (alt4) {
				case 1 :
					// .\\grammar\\JSON.g:119:4: String
					{
					String15=(Token)match(input,String,FOLLOW_String_in_value534);  
					stream_String.add(String15);

					// AST REWRITE
					// elements: String
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 119:11: -> ^( XML_ELEMENT[\"string\"] String )
					{
						// .\\grammar\\JSON.g:119:14: ^( XML_ELEMENT[\"string\"] String )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(XML_ELEMENT, "string"), root_1);
						adaptor.addChild(root_1, stream_String.nextNode());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 2 :
					// .\\grammar\\JSON.g:120:4: Integer
					{
					Integer16=(Token)match(input,Integer,FOLLOW_Integer_in_value548);  
					stream_Integer.add(Integer16);

					// AST REWRITE
					// elements: Integer
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 120:12: -> ^( XML_ELEMENT[\"integer\"] Integer )
					{
						// .\\grammar\\JSON.g:120:15: ^( XML_ELEMENT[\"integer\"] Integer )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(XML_ELEMENT, "integer"), root_1);
						adaptor.addChild(root_1, stream_Integer.nextNode());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 3 :
					// .\\grammar\\JSON.g:121:4: Double
					{
					Double17=(Token)match(input,Double,FOLLOW_Double_in_value562);  
					stream_Double.add(Double17);

					// AST REWRITE
					// elements: Double
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 121:11: -> ^( XML_ELEMENT[\"double\"] Double )
					{
						// .\\grammar\\JSON.g:121:14: ^( XML_ELEMENT[\"double\"] Double )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(XML_ELEMENT, "double"), root_1);
						adaptor.addChild(root_1, stream_Double.nextNode());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 4 :
					// .\\grammar\\JSON.g:122:4: Boolean
					{
					Boolean18=(Token)match(input,Boolean,FOLLOW_Boolean_in_value576);  
					stream_Boolean.add(Boolean18);

					// AST REWRITE
					// elements: Boolean
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 122:12: -> ^( XML_ELEMENT[\"boolean\"] Boolean )
					{
						// .\\grammar\\JSON.g:122:15: ^( XML_ELEMENT[\"boolean\"] Boolean )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(XML_ELEMENT, "boolean"), root_1);
						adaptor.addChild(root_1, stream_Boolean.nextNode());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 5 :
					// .\\grammar\\JSON.g:123:4: object
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_object_in_value590);
					object19=object();
					state._fsp--;

					adaptor.addChild(root_0, object19.getTree());

					}
					break;
				case 6 :
					// .\\grammar\\JSON.g:124:4: array
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_array_in_value597);
					array20=array();
					state._fsp--;

					adaptor.addChild(root_0, array20.getTree());

					}
					break;
				case 7 :
					// .\\grammar\\JSON.g:125:4: NULL
					{
					root_0 = (Object)adaptor.nil();


					NULL21=(Token)match(input,NULL,FOLLOW_NULL_in_value604); 
					NULL21_tree = (Object)adaptor.create(NULL21);
					adaptor.addChild(root_0, NULL21_tree);

					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "value"

	// Delegated rules



	public static final BitSet FOLLOW_value_in_json411 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_25_in_object422 = new BitSet(new long[]{0x0000000004008000L});
	public static final BitSet FOLLOW_field_in_object425 = new BitSet(new long[]{0x0000000004200000L});
	public static final BitSet FOLLOW_21_in_object428 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_field_in_object430 = new BitSet(new long[]{0x0000000004200000L});
	public static final BitSet FOLLOW_26_in_object436 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_String_in_field461 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_22_in_field463 = new BitSet(new long[]{0x000000000280E090L});
	public static final BitSet FOLLOW_value_in_field465 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_23_in_array497 = new BitSet(new long[]{0x000000000280E090L});
	public static final BitSet FOLLOW_value_in_array499 = new BitSet(new long[]{0x0000000001200000L});
	public static final BitSet FOLLOW_21_in_array502 = new BitSet(new long[]{0x000000000280E090L});
	public static final BitSet FOLLOW_value_in_array504 = new BitSet(new long[]{0x0000000001200000L});
	public static final BitSet FOLLOW_24_in_array508 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_String_in_value534 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Integer_in_value548 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Double_in_value562 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Boolean_in_value576 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_object_in_value590 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_array_in_value597 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NULL_in_value604 = new BitSet(new long[]{0x0000000000000002L});
}
