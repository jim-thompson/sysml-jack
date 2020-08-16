/* Generated By:JavaCC: Do not edit this line. JJTest2.java */
package com.delligattiassociates.jct.test.parser;

public class JJTest2 implements JJTest2Constants {
  void report(String s)
  {
        System.out.printf("Parsed <%s>.\u005cn", s);
  }

  final public void doc_comment() throws ParseException {
    jj_consume_token(T_COMMENT);
                 System.out.println("Scanned a doc comment");
  }

  final public void named_comment() throws ParseException {
    jj_consume_token(K_COMMENT);
    jj_consume_token(T_IDENTIFIER);
    doc_comment();
                                             System.out.println("Scanned a named comment");
  }

  final public void comment_about() throws ParseException {
    jj_consume_token(K_COMMENT);
    jj_consume_token(K_ABOUT);
    jj_consume_token(T_IDENTIFIER);
    doc_comment();
  }

  final public void maybe_scoped_id() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case T_IDENTIFIER:
      jj_consume_token(T_IDENTIFIER);
      break;
    case T_SCOPED_IDENTIFIER:
      jj_consume_token(T_SCOPED_IDENTIFIER);
      break;
    default:
      jj_la1[0] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void alias() throws ParseException {
    jj_consume_token(K_ALIAS);
    maybe_scoped_id();
    jj_consume_token(K_AS);
    jj_consume_token(T_IDENTIFIER);
    jj_consume_token(35);
  }

  final public void block() throws ParseException {
    jj_consume_token(K_BLOCK);
    jj_consume_token(T_IDENTIFIER);
    jj_consume_token(35);
  }

  final public void class_() throws ParseException {
    jj_consume_token(K_CLASS);
    jj_consume_token(T_IDENTIFIER);
    jj_consume_token(T_LBRACE);
    jj_consume_token(T_RBRACE);
    jj_consume_token(35);
  }

  final public void import_() throws ParseException {
    if (jj_2_1(3)) {
      jj_consume_token(K_IMPORT);
      maybe_scoped_id();
      jj_consume_token(35);
    } else if (jj_2_2(3)) {
      jj_consume_token(K_IMPORT);
      maybe_scoped_id();
      jj_consume_token(K_AS);
      jj_consume_token(T_IDENTIFIER);
      jj_consume_token(35);
    } else {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case K_IMPORT:
        jj_consume_token(K_IMPORT);
        maybe_scoped_id();
        jj_consume_token(O_SCOPE);
        jj_consume_token(O_SPLAT);
        jj_consume_token(35);
        break;
      default:
        jj_la1[1] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
  }

  final public void feature() throws ParseException {
    jj_consume_token(K_FEATURE);
    jj_consume_token(T_IDENTIFIER);
    jj_consume_token(O_COLON);
    jj_consume_token(T_IDENTIFIER);
    jj_consume_token(35);
  }

  final public void namespace() throws ParseException {
    jj_consume_token(K_NAMESPACE);
    jj_consume_token(T_IDENTIFIER);
    jj_consume_token(T_LBRACE);
    lines();
    jj_consume_token(T_RBRACE);
    jj_consume_token(35);
  }

  final public void visibility() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case K_PUBLIC:
      jj_consume_token(K_PUBLIC);
      break;
    case K_PRIVATE:
      jj_consume_token(K_PRIVATE);
      break;
    default:
      jj_la1[2] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void null_statement() throws ParseException {
    jj_consume_token(35);
  }

  final public void lines() throws ParseException {
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case T_COMMENT:
      case K_NAMESPACE:
      case K_PACKAGE:
      case K_COMMENT:
      case K_IMPORT:
      case K_BLOCK:
      case K_ALIAS:
      case K_FEATURE:
      case K_CLASS:
      case 35:
        ;
        break;
      default:
        jj_la1[3] = jj_gen;
        break label_1;
      }
      one_line();
    }
  }

  final public void package_() throws ParseException {
    jj_consume_token(K_PACKAGE);
    jj_consume_token(T_IDENTIFIER);
    jj_consume_token(T_LBRACE);
    label_2:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case T_COMMENT:
      case K_COMMENT:
      case K_IMPORT:
      case K_BLOCK:
      case K_ALIAS:
      case K_PRIVATE:
      case K_PUBLIC:
        ;
        break;
      default:
        jj_la1[4] = jj_gen;
        break label_2;
      }
      packageable_expr();
    }
    jj_consume_token(T_RBRACE);
  }

  final public void packageable_expr() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case K_PRIVATE:
    case K_PUBLIC:
      visibility();
      break;
    default:
      jj_la1[5] = jj_gen;
      ;
    }
    packageable_decl();
  }

  final public void packageable_decl() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case T_COMMENT:
      doc_comment();
      break;
    default:
      jj_la1[6] = jj_gen;
      if (jj_2_3(2)) {
        named_comment();
      } else {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case K_COMMENT:
          comment_about();
          break;
        case K_IMPORT:
          import_();
          break;
        case K_BLOCK:
          block();
          break;
        case K_ALIAS:
          alias();
          break;
        default:
          jj_la1[7] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
      }
    }
  }

  final public void one_line() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case T_COMMENT:
      doc_comment();
      break;
    default:
      jj_la1[8] = jj_gen;
      if (jj_2_4(2)) {
        named_comment();
      } else {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case K_COMMENT:
          comment_about();
                    report("about comment");
          break;
        case K_NAMESPACE:
          namespace();
                report("namespace");
          break;
        case K_ALIAS:
          alias();
             report("alias");
          break;
        case K_BLOCK:
          block();
             report("block");
          break;
        case K_PACKAGE:
          package_();
               report("package");
          break;
        case K_IMPORT:
          import_();
              report("import");
          break;
        case K_CLASS:
          class_();
              report("class");
          break;
        case K_FEATURE:
          feature();
              report("feature");
          break;
        case 35:
          jj_consume_token(35);
         System.out.println("That was an empty line!");
          break;
        default:
          jj_la1[9] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
      }
    }
  }

  final public void end() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 0:
      jj_consume_token(0);
      break;
    case K_QUIT:
      jj_consume_token(K_QUIT);
      break;
    default:
      jj_la1[10] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void file() throws ParseException {
    label_3:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case T_COMMENT:
      case K_NAMESPACE:
      case K_PACKAGE:
      case K_COMMENT:
      case K_IMPORT:
      case K_BLOCK:
      case K_ALIAS:
      case K_FEATURE:
      case K_CLASS:
      case 35:
        ;
        break;
      default:
        jj_la1[11] = jj_gen;
        break label_3;
      }
      one_line();
    }
    end();
  }

  private boolean jj_2_1(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_1(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(0, xla); }
  }

  private boolean jj_2_2(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_2(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(1, xla); }
  }

  private boolean jj_2_3(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_3(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(2, xla); }
  }

  private boolean jj_2_4(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_4(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(3, xla); }
  }

  private boolean jj_3R_5() {
    if (jj_scan_token(K_COMMENT)) return true;
    if (jj_scan_token(T_IDENTIFIER)) return true;
    return false;
  }

  private boolean jj_3_2() {
    if (jj_scan_token(K_IMPORT)) return true;
    if (jj_3R_4()) return true;
    if (jj_scan_token(K_AS)) return true;
    return false;
  }

  private boolean jj_3R_4() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_scan_token(29)) {
    jj_scanpos = xsp;
    if (jj_scan_token(33)) return true;
    }
    return false;
  }

  private boolean jj_3_4() {
    if (jj_3R_5()) return true;
    return false;
  }

  private boolean jj_3_3() {
    if (jj_3R_5()) return true;
    return false;
  }

  private boolean jj_3_1() {
    if (jj_scan_token(K_IMPORT)) return true;
    if (jj_3R_4()) return true;
    if (jj_scan_token(35)) return true;
    return false;
  }

  /** Generated Token Manager. */
  public JJTest2TokenManager token_source;
  SimpleCharStream jj_input_stream;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;
  private int jj_ntk;
  private Token jj_scanpos, jj_lastpos;
  private int jj_la;
  private int jj_gen;
  final private int[] jj_la1 = new int[12];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static {
      jj_la1_init_0();
      jj_la1_init_1();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x20000000,0x8000,0x600000,0x1bb840,0x63a040,0x600000,0x40,0x3a000,0x40,0x1bb800,0x800001,0x1bb840,};
   }
   private static void jj_la1_init_1() {
      jj_la1_1 = new int[] {0x2,0x0,0x0,0x8,0x0,0x0,0x0,0x0,0x0,0x8,0x0,0x8,};
   }
  final private JJCalls[] jj_2_rtns = new JJCalls[4];
  private boolean jj_rescan = false;
  private int jj_gc = 0;

  /** Constructor with InputStream. */
  public JJTest2(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public JJTest2(java.io.InputStream stream, String encoding) {
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new JJTest2TokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 12; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 12; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor. */
  public JJTest2(java.io.Reader stream) {
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new JJTest2TokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 12; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 12; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor with generated Token Manager. */
  public JJTest2(JJTest2TokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 12; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(JJTest2TokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 12; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      if (++jj_gc > 100) {
        jj_gc = 0;
        for (int i = 0; i < jj_2_rtns.length; i++) {
          JJCalls c = jj_2_rtns[i];
          while (c != null) {
            if (c.gen < jj_gen) c.first = null;
            c = c.next;
          }
        }
      }
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }

  static private final class LookaheadSuccess extends java.lang.Error { }
  final private LookaheadSuccess jj_ls = new LookaheadSuccess();
  private boolean jj_scan_token(int kind) {
    if (jj_scanpos == jj_lastpos) {
      jj_la--;
      if (jj_scanpos.next == null) {
        jj_lastpos = jj_scanpos = jj_scanpos.next = token_source.getNextToken();
      } else {
        jj_lastpos = jj_scanpos = jj_scanpos.next;
      }
    } else {
      jj_scanpos = jj_scanpos.next;
    }
    if (jj_rescan) {
      int i = 0; Token tok = token;
      while (tok != null && tok != jj_scanpos) { i++; tok = tok.next; }
      if (tok != null) jj_add_error_token(kind, i);
    }
    if (jj_scanpos.kind != kind) return true;
    if (jj_la == 0 && jj_scanpos == jj_lastpos) throw jj_ls;
    return false;
  }


/** Get the next Token. */
  final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  private int[] jj_expentry;
  private int jj_kind = -1;
  private int[] jj_lasttokens = new int[100];
  private int jj_endpos;

  private void jj_add_error_token(int kind, int pos) {
    if (pos >= 100) return;
    if (pos == jj_endpos + 1) {
      jj_lasttokens[jj_endpos++] = kind;
    } else if (jj_endpos != 0) {
      jj_expentry = new int[jj_endpos];
      for (int i = 0; i < jj_endpos; i++) {
        jj_expentry[i] = jj_lasttokens[i];
      }
      jj_entries_loop: for (java.util.Iterator<?> it = jj_expentries.iterator(); it.hasNext();) {
        int[] oldentry = (int[])(it.next());
        if (oldentry.length == jj_expentry.length) {
          for (int i = 0; i < jj_expentry.length; i++) {
            if (oldentry[i] != jj_expentry[i]) {
              continue jj_entries_loop;
            }
          }
          jj_expentries.add(jj_expentry);
          break jj_entries_loop;
        }
      }
      if (pos != 0) jj_lasttokens[(jj_endpos = pos) - 1] = kind;
    }
  }

  /** Generate ParseException. */
  public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[36];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 12; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
          if ((jj_la1_1[i] & (1<<j)) != 0) {
            la1tokens[32+j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 36; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    jj_endpos = 0;
    jj_rescan_token();
    jj_add_error_token(0, 0);
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  final public void enable_tracing() {
  }

  /** Disable tracing. */
  final public void disable_tracing() {
  }

  private void jj_rescan_token() {
    jj_rescan = true;
    for (int i = 0; i < 4; i++) {
    try {
      JJCalls p = jj_2_rtns[i];
      do {
        if (p.gen > jj_gen) {
          jj_la = p.arg; jj_lastpos = jj_scanpos = p.first;
          switch (i) {
            case 0: jj_3_1(); break;
            case 1: jj_3_2(); break;
            case 2: jj_3_3(); break;
            case 3: jj_3_4(); break;
          }
        }
        p = p.next;
      } while (p != null);
      } catch(LookaheadSuccess ls) { }
    }
    jj_rescan = false;
  }

  private void jj_save(int index, int xla) {
    JJCalls p = jj_2_rtns[index];
    while (p.gen > jj_gen) {
      if (p.next == null) { p = p.next = new JJCalls(); break; }
      p = p.next;
    }
    p.gen = jj_gen + xla - jj_la; p.first = token; p.arg = xla;
  }

  static final class JJCalls {
    int gen;
    Token first;
    int arg;
    JJCalls next;
  }

}