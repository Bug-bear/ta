println "Give me a string and I will calculate its hash code";
String str = System.console().readLine();
int hash = str.hashCode();
println hash;
int smallHash = HashUtilities.shortHash(hash);
System.out.println("0 < " + smallHash + " < 1000");