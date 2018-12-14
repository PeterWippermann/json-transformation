// $ANTLR 3.5.2 .\\grammar\\JSON.g 2018-12-14 23:42:11

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

@SuppressWarnings("all")
public class JSONLexer extends Lexer {
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
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public JSONLexer() {} 
	public JSONLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public JSONLexer(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return ".\\grammar\\JSON.g"; }

	// $ANTLR start "T__21"
	public final void mT__21() throws RecognitionException {
		try {
			int _type = T__21;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// .\\grammar\\JSON.g:17:7: ( ',' )
			// .\\grammar\\JSON.g:17:9: ','
			{
			match(','); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__21"

	// $ANTLR start "T__22"
	public final void mT__22() throws RecognitionException {
		try {
			int _type = T__22;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// .\\grammar\\JSON.g:18:7: ( ':' )
			// .\\grammar\\JSON.g:18:9: ':'
			{
			match(':'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__22"

	// $ANTLR start "T__23"
	public final void mT__23() throws RecognitionException {
		try {
			int _type = T__23;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// .\\grammar\\JSON.g:19:7: ( '[' )
			// .\\grammar\\JSON.g:19:9: '['
			{
			match('['); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__23"

	// $ANTLR start "T__24"
	public final void mT__24() throws RecognitionException {
		try {
			int _type = T__24;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// .\\grammar\\JSON.g:20:7: ( ']' )
			// .\\grammar\\JSON.g:20:9: ']'
			{
			match(']'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__24"

	// $ANTLR start "T__25"
	public final void mT__25() throws RecognitionException {
		try {
			int _type = T__25;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// .\\grammar\\JSON.g:21:7: ( '{' )
			// .\\grammar\\JSON.g:21:9: '{'
			{
			match('{'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__25"

	// $ANTLR start "T__26"
	public final void mT__26() throws RecognitionException {
		try {
			int _type = T__26;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// .\\grammar\\JSON.g:22:7: ( '}' )
			// .\\grammar\\JSON.g:22:9: '}'
			{
			match('}'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__26"

	// $ANTLR start "Dot"
	public final void mDot() throws RecognitionException {
		try {
			// .\\grammar\\JSON.g:64:13: ( '.' )
			// .\\grammar\\JSON.g:64:15: '.'
			{
			match('.'); 
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Dot"

	// $ANTLR start "NULL"
	public final void mNULL() throws RecognitionException {
		try {
			int _type = NULL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// .\\grammar\\JSON.g:65:5: ( 'null' )
			// .\\grammar\\JSON.g:65:7: 'null'
			{
			match("null"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NULL"

	// $ANTLR start "Digit"
	public final void mDigit() throws RecognitionException {
		try {
			// .\\grammar\\JSON.g:67:15: ( '0' .. '9' )
			// .\\grammar\\JSON.g:
			{
			if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Digit"

	// $ANTLR start "HexDigit"
	public final void mHexDigit() throws RecognitionException {
		try {
			// .\\grammar\\JSON.g:68:18: ( ( '0' .. '9' | 'A' .. 'F' | 'a' .. 'f' ) )
			// .\\grammar\\JSON.g:
			{
			if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'F')||(input.LA(1) >= 'a' && input.LA(1) <= 'f') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "HexDigit"

	// $ANTLR start "UnicodeChar"
	public final void mUnicodeChar() throws RecognitionException {
		try {
			// .\\grammar\\JSON.g:69:21: (~ ( '\"' | '\\\\' ) )
			// .\\grammar\\JSON.g:
			{
			if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '!')||(input.LA(1) >= '#' && input.LA(1) <= '[')||(input.LA(1) >= ']' && input.LA(1) <= '\uFFFF') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "UnicodeChar"

	// $ANTLR start "StringChar"
	public final void mStringChar() throws RecognitionException {
		try {
			// .\\grammar\\JSON.g:70:21: ( UnicodeChar | EscapeSequence )
			int alt1=2;
			int LA1_0 = input.LA(1);
			if ( ((LA1_0 >= '\u0000' && LA1_0 <= '!')||(LA1_0 >= '#' && LA1_0 <= '[')||(LA1_0 >= ']' && LA1_0 <= '\uFFFF')) ) {
				alt1=1;
			}
			else if ( (LA1_0=='\\') ) {
				alt1=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 1, 0, input);
				throw nvae;
			}

			switch (alt1) {
				case 1 :
					// .\\grammar\\JSON.g:70:24: UnicodeChar
					{
					mUnicodeChar(); 

					}
					break;
				case 2 :
					// .\\grammar\\JSON.g:70:38: EscapeSequence
					{
					mEscapeSequence(); 

					}
					break;

			}
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "StringChar"

	// $ANTLR start "EscapeSequence"
	public final void mEscapeSequence() throws RecognitionException {
		try {
			// .\\grammar\\JSON.g:73:2: ( '\\\\' ( '\\\"' | '\\\\' | '/' | 'b' | 'f' | 'n' | 'r' | 't' | 'u' HexDigit HexDigit HexDigit HexDigit ) )
			// .\\grammar\\JSON.g:73:4: '\\\\' ( '\\\"' | '\\\\' | '/' | 'b' | 'f' | 'n' | 'r' | 't' | 'u' HexDigit HexDigit HexDigit HexDigit )
			{
			match('\\'); 
			// .\\grammar\\JSON.g:74:4: ( '\\\"' | '\\\\' | '/' | 'b' | 'f' | 'n' | 'r' | 't' | 'u' HexDigit HexDigit HexDigit HexDigit )
			int alt2=9;
			switch ( input.LA(1) ) {
			case '\"':
				{
				alt2=1;
				}
				break;
			case '\\':
				{
				alt2=2;
				}
				break;
			case '/':
				{
				alt2=3;
				}
				break;
			case 'b':
				{
				alt2=4;
				}
				break;
			case 'f':
				{
				alt2=5;
				}
				break;
			case 'n':
				{
				alt2=6;
				}
				break;
			case 'r':
				{
				alt2=7;
				}
				break;
			case 't':
				{
				alt2=8;
				}
				break;
			case 'u':
				{
				alt2=9;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}
			switch (alt2) {
				case 1 :
					// .\\grammar\\JSON.g:74:5: '\\\"'
					{
					match('\"'); 
					}
					break;
				case 2 :
					// .\\grammar\\JSON.g:75:5: '\\\\'
					{
					match('\\'); 
					setText("\\");
					}
					break;
				case 3 :
					// .\\grammar\\JSON.g:76:6: '/'
					{
					match('/'); 
					setText("/");
					}
					break;
				case 4 :
					// .\\grammar\\JSON.g:77:6: 'b'
					{
					match('b'); 
					setText("\b");
					}
					break;
				case 5 :
					// .\\grammar\\JSON.g:78:6: 'f'
					{
					match('f'); 
					setText("\f");
					}
					break;
				case 6 :
					// .\\grammar\\JSON.g:79:6: 'n'
					{
					match('n'); 
					setText("\n");
					}
					break;
				case 7 :
					// .\\grammar\\JSON.g:80:6: 'r'
					{
					match('r'); 
					setText("\r");
					}
					break;
				case 8 :
					// .\\grammar\\JSON.g:81:6: 't'
					{
					match('t'); 
					setText("\t");
					}
					break;
				case 9 :
					// .\\grammar\\JSON.g:82:6: 'u' HexDigit HexDigit HexDigit HexDigit
					{
					match('u'); 
					mHexDigit(); 

					mHexDigit(); 

					mHexDigit(); 

					mHexDigit(); 

					}
					break;

			}

			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EscapeSequence"

	// $ANTLR start "Int"
	public final void mInt() throws RecognitionException {
		try {
			// .\\grammar\\JSON.g:86:13: ( ( '-' )? ( '0' | '1' .. '9' ( Digit )* ) )
			// .\\grammar\\JSON.g:86:15: ( '-' )? ( '0' | '1' .. '9' ( Digit )* )
			{
			// .\\grammar\\JSON.g:86:15: ( '-' )?
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0=='-') ) {
				alt3=1;
			}
			switch (alt3) {
				case 1 :
					// .\\grammar\\JSON.g:86:15: '-'
					{
					match('-'); 
					}
					break;

			}

			// .\\grammar\\JSON.g:86:20: ( '0' | '1' .. '9' ( Digit )* )
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( (LA5_0=='0') ) {
				alt5=1;
			}
			else if ( ((LA5_0 >= '1' && LA5_0 <= '9')) ) {
				alt5=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 5, 0, input);
				throw nvae;
			}

			switch (alt5) {
				case 1 :
					// .\\grammar\\JSON.g:86:21: '0'
					{
					match('0'); 
					}
					break;
				case 2 :
					// .\\grammar\\JSON.g:86:27: '1' .. '9' ( Digit )*
					{
					matchRange('1','9'); 
					// .\\grammar\\JSON.g:86:36: ( Digit )*
					loop4:
					while (true) {
						int alt4=2;
						int LA4_0 = input.LA(1);
						if ( ((LA4_0 >= '0' && LA4_0 <= '9')) ) {
							alt4=1;
						}

						switch (alt4) {
						case 1 :
							// .\\grammar\\JSON.g:
							{
							if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
								input.consume();
							}
							else {
								MismatchedSetException mse = new MismatchedSetException(null,input);
								recover(mse);
								throw mse;
							}
							}
							break;

						default :
							break loop4;
						}
					}

					}
					break;

			}

			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Int"

	// $ANTLR start "Frac"
	public final void mFrac() throws RecognitionException {
		try {
			// .\\grammar\\JSON.g:87:14: ( Dot ( Digit )+ )
			// .\\grammar\\JSON.g:87:16: Dot ( Digit )+
			{
			mDot(); 

			// .\\grammar\\JSON.g:87:20: ( Digit )+
			int cnt6=0;
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( ((LA6_0 >= '0' && LA6_0 <= '9')) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// .\\grammar\\JSON.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt6 >= 1 ) break loop6;
					EarlyExitException eee = new EarlyExitException(6, input);
					throw eee;
				}
				cnt6++;
			}

			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Frac"

	// $ANTLR start "Exp"
	public final void mExp() throws RecognitionException {
		try {
			// .\\grammar\\JSON.g:88:13: ( ( 'e' | 'E' ) ( '+' | '-' )? ( Digit )+ )
			// .\\grammar\\JSON.g:88:15: ( 'e' | 'E' ) ( '+' | '-' )? ( Digit )+
			{
			if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// .\\grammar\\JSON.g:88:27: ( '+' | '-' )?
			int alt7=2;
			int LA7_0 = input.LA(1);
			if ( (LA7_0=='+'||LA7_0=='-') ) {
				alt7=1;
			}
			switch (alt7) {
				case 1 :
					// .\\grammar\\JSON.g:
					{
					if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

			}

			// .\\grammar\\JSON.g:88:40: ( Digit )+
			int cnt8=0;
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( ((LA8_0 >= '0' && LA8_0 <= '9')) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// .\\grammar\\JSON.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt8 >= 1 ) break loop8;
					EarlyExitException eee = new EarlyExitException(8, input);
					throw eee;
				}
				cnt8++;
			}

			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Exp"

	// $ANTLR start "WhiteSpace"
	public final void mWhiteSpace() throws RecognitionException {
		try {
			int _type = WhiteSpace;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// .\\grammar\\JSON.g:90:11: ( ( ' ' | '\\r' | '\\t' | '\\u000C' | '\\n' ) )
			// .\\grammar\\JSON.g:90:13: ( ' ' | '\\r' | '\\t' | '\\u000C' | '\\n' )
			{
			if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||(input.LA(1) >= '\f' && input.LA(1) <= '\r')||input.LA(1)==' ' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			 _channel=HIDDEN; 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WhiteSpace"

	// $ANTLR start "String"
	public final void mString() throws RecognitionException {
		try {
			int _type = String;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			CommonToken c=null;

			StringBuilder sb = new StringBuilder();
			// .\\grammar\\JSON.g:92:55: ( '\"' (c= StringChar )* '\"' )
			// .\\grammar\\JSON.g:92:57: '\"' (c= StringChar )* '\"'
			{
			match('\"'); 
			// .\\grammar\\JSON.g:92:61: (c= StringChar )*
			loop9:
			while (true) {
				int alt9=2;
				int LA9_0 = input.LA(1);
				if ( ((LA9_0 >= '\u0000' && LA9_0 <= '!')||(LA9_0 >= '#' && LA9_0 <= '\uFFFF')) ) {
					alt9=1;
				}

				switch (alt9) {
				case 1 :
					// .\\grammar\\JSON.g:92:62: c= StringChar
					{
					int cStart361 = getCharIndex();
					int cStartLine361 = getLine();
					int cStartCharPos361 = getCharPositionInLine();
					mStringChar(); 
					c = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, cStart361, getCharIndex()-1);
					c.setLine(cStartLine361);
					c.setCharPositionInLine(cStartCharPos361);

					sb.append(c.getText());
					}
					break;

				default :
					break loop9;
				}
			}

			match('\"'); 
			setText(sb.toString());
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "String"

	// $ANTLR start "Integer"
	public final void mInteger() throws RecognitionException {
		try {
			int _type = Integer;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// .\\grammar\\JSON.g:93:8: ( Int )
			// .\\grammar\\JSON.g:93:10: Int
			{
			mInt(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Integer"

	// $ANTLR start "Double"
	public final void mDouble() throws RecognitionException {
		try {
			int _type = Double;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// .\\grammar\\JSON.g:94:7: ( Int ( Frac ( Exp )? | Exp ) )
			// .\\grammar\\JSON.g:94:10: Int ( Frac ( Exp )? | Exp )
			{
			mInt(); 

			// .\\grammar\\JSON.g:94:14: ( Frac ( Exp )? | Exp )
			int alt11=2;
			int LA11_0 = input.LA(1);
			if ( (LA11_0=='.') ) {
				alt11=1;
			}
			else if ( (LA11_0=='E'||LA11_0=='e') ) {
				alt11=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 11, 0, input);
				throw nvae;
			}

			switch (alt11) {
				case 1 :
					// .\\grammar\\JSON.g:94:15: Frac ( Exp )?
					{
					mFrac(); 

					// .\\grammar\\JSON.g:94:20: ( Exp )?
					int alt10=2;
					int LA10_0 = input.LA(1);
					if ( (LA10_0=='E'||LA10_0=='e') ) {
						alt10=1;
					}
					switch (alt10) {
						case 1 :
							// .\\grammar\\JSON.g:94:20: Exp
							{
							mExp(); 

							}
							break;

					}

					}
					break;
				case 2 :
					// .\\grammar\\JSON.g:94:27: Exp
					{
					mExp(); 

					}
					break;

			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Double"

	// $ANTLR start "Boolean"
	public final void mBoolean() throws RecognitionException {
		try {
			int _type = Boolean;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// .\\grammar\\JSON.g:95:8: ( 'false' | 'true' )
			int alt12=2;
			int LA12_0 = input.LA(1);
			if ( (LA12_0=='f') ) {
				alt12=1;
			}
			else if ( (LA12_0=='t') ) {
				alt12=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 12, 0, input);
				throw nvae;
			}

			switch (alt12) {
				case 1 :
					// .\\grammar\\JSON.g:95:10: 'false'
					{
					match("false"); 

					}
					break;
				case 2 :
					// .\\grammar\\JSON.g:95:20: 'true'
					{
					match("true"); 

					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Boolean"

	@Override
	public void mTokens() throws RecognitionException {
		// .\\grammar\\JSON.g:1:8: ( T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | NULL | WhiteSpace | String | Integer | Double | Boolean )
		int alt13=12;
		alt13 = dfa13.predict(input);
		switch (alt13) {
			case 1 :
				// .\\grammar\\JSON.g:1:10: T__21
				{
				mT__21(); 

				}
				break;
			case 2 :
				// .\\grammar\\JSON.g:1:16: T__22
				{
				mT__22(); 

				}
				break;
			case 3 :
				// .\\grammar\\JSON.g:1:22: T__23
				{
				mT__23(); 

				}
				break;
			case 4 :
				// .\\grammar\\JSON.g:1:28: T__24
				{
				mT__24(); 

				}
				break;
			case 5 :
				// .\\grammar\\JSON.g:1:34: T__25
				{
				mT__25(); 

				}
				break;
			case 6 :
				// .\\grammar\\JSON.g:1:40: T__26
				{
				mT__26(); 

				}
				break;
			case 7 :
				// .\\grammar\\JSON.g:1:46: NULL
				{
				mNULL(); 

				}
				break;
			case 8 :
				// .\\grammar\\JSON.g:1:51: WhiteSpace
				{
				mWhiteSpace(); 

				}
				break;
			case 9 :
				// .\\grammar\\JSON.g:1:62: String
				{
				mString(); 

				}
				break;
			case 10 :
				// .\\grammar\\JSON.g:1:69: Integer
				{
				mInteger(); 

				}
				break;
			case 11 :
				// .\\grammar\\JSON.g:1:77: Double
				{
				mDouble(); 

				}
				break;
			case 12 :
				// .\\grammar\\JSON.g:1:84: Boolean
				{
				mBoolean(); 

				}
				break;

		}
	}


	protected DFA13 dfa13 = new DFA13(this);
	static final String DFA13_eotS =
		"\13\uffff\2\16\3\uffff\1\16";
	static final String DFA13_eofS =
		"\21\uffff";
	static final String DFA13_minS =
		"\1\11\11\uffff\1\60\2\56\3\uffff\1\56";
	static final String DFA13_maxS =
		"\1\175\11\uffff\1\71\2\145\3\uffff\1\145";
	static final String DFA13_acceptS =
		"\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\3\uffff\1\14\1\12\1\13"+
		"\1\uffff";
	static final String DFA13_specialS =
		"\21\uffff}>";
	static final String[] DFA13_transitionS = {
			"\2\10\1\uffff\2\10\22\uffff\1\10\1\uffff\1\11\11\uffff\1\1\1\12\2\uffff"+
			"\1\13\11\14\1\2\40\uffff\1\3\1\uffff\1\4\10\uffff\1\15\7\uffff\1\7\5"+
			"\uffff\1\15\6\uffff\1\5\1\uffff\1\6",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\13\11\14",
			"\1\17\26\uffff\1\17\37\uffff\1\17",
			"\1\17\1\uffff\12\20\13\uffff\1\17\37\uffff\1\17",
			"",
			"",
			"",
			"\1\17\1\uffff\12\20\13\uffff\1\17\37\uffff\1\17"
	};

	static final short[] DFA13_eot = DFA.unpackEncodedString(DFA13_eotS);
	static final short[] DFA13_eof = DFA.unpackEncodedString(DFA13_eofS);
	static final char[] DFA13_min = DFA.unpackEncodedStringToUnsignedChars(DFA13_minS);
	static final char[] DFA13_max = DFA.unpackEncodedStringToUnsignedChars(DFA13_maxS);
	static final short[] DFA13_accept = DFA.unpackEncodedString(DFA13_acceptS);
	static final short[] DFA13_special = DFA.unpackEncodedString(DFA13_specialS);
	static final short[][] DFA13_transition;

	static {
		int numStates = DFA13_transitionS.length;
		DFA13_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA13_transition[i] = DFA.unpackEncodedString(DFA13_transitionS[i]);
		}
	}

	protected class DFA13 extends DFA {

		public DFA13(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 13;
			this.eot = DFA13_eot;
			this.eof = DFA13_eof;
			this.min = DFA13_min;
			this.max = DFA13_max;
			this.accept = DFA13_accept;
			this.special = DFA13_special;
			this.transition = DFA13_transition;
		}
		@Override
		public String getDescription() {
			return "1:1: Tokens : ( T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | NULL | WhiteSpace | String | Integer | Double | Boolean );";
		}
	}

}
