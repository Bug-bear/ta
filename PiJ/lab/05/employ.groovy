EmployeeList record = new EmployeeList();

Boolean finished = false;

//input
while(!finished){
	String str;
	println "give me a name"
	str = System.console().readLine();
	if(str.length() != 0){
		record.readName(str);
	} else{
		finished = true;
		break;
	}
	println "give me an ID"
	str = System.console().readLine();
	int id = Integer.parseInt(str);
	if(id != 0){
		record.readID(id);
	} else{
		finished = true;
		break;	
	}
}

//output
int pos = 0;
while(record.getName(pos)!="" && record.getID(pos)!=0){
	println "employ name: " + record.getName(pos) + " and ID is " + record.getID(pos);
	pos++;
}