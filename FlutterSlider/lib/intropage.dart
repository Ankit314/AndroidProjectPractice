import 'package:flutter/material.dart';
import 'package:flutterslider/main.dart';

class IntroPage extends StatelessWidget{
  @override
  Widget build(BuildContext context) {
     return Scaffold(
       appBar: AppBar(
         title: Text('intro'),
       ),

       body: Center(
         child: Column(

           children: [Text('Welcome',style: TextStyle(fontSize: 34,fontWeight: FontWeight.bold,),)
           ,
           SizedBox(height: 11,),ElevatedButton(onPressed: (){
             Navigator.push(context, MaterialPageRoute(builder:(context)=> MyHomePage(),


             ));

             }, child: Text('Next'))],
         ),
       )
     );
  }
  
}