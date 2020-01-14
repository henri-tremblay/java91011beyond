// jshell --enable-preview

// Escape character
var s = """
        a\tb"""

// Trailing whitespaces
var s = """
        a   \s"""

// Multiline
var s = """
        a\
        b\
        c"""
String source = """
                public void print(%s object) {
                    System.out.println(Objects.toString(object));
                }
                """.formatted(type);

// Pattern-matching (https://openjdk.java.net/jeps/305)
Object obj = "aaa"
if(obj instanceof String) System.out.println(((String) obj).length())
if(obj instanceof String s) System.out.println(s.length())

// Record
record Point(int x, int y) {}
var p = new Point(3,4) // immutable
p.x()
p.y()
System.out.println(p)
var q = new Point(3,4)
p == q
p.equals(q)
// can't extend
// no other fields apart from static ones

/exit
