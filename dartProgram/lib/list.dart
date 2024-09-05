main(){

  var list=[30,40,90,10,20];
  list.add(80);
  print(list);

  var name=[];
  name.add("Ankit");
  name.add("Aman");
  name.add("Aryan");
  name.add("Ansu");
  // name.addAll(list);
  name.insert(2, "Kran");
  name[3]="Akash";
  // name.insertAll(3, list);

  list.replaceRange(0, 3, [1,2,3,4]);
  
  print("Length:${list.length}");
  print("Reverse: ${list.reversed}");
  print("FirstElement:${list.first}");
  print("LastElement:${list.last}");
  print("EmptyElement:${list.isEmpty}");
  print("is Not Empty:${list.isNotEmpty}");




  list.remove(20);
  list.removeAt(1);
  list.removeRange(0, 3);


  print(list);


  print(name);



}