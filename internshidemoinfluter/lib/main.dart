import 'package:flutter/material.dart';




// function to trigger build when the app is run
void main() {
  runApp(MaterialApp(
    initialRoute: '/',
    routes: {
      '/': (context) => const HomeRoute(),
      '/second': (context) => const SecondRoute(),
      '/third': (context) => const ThirdRoute(),
    },
  )); //MaterialApp
}

class HomeRoute extends StatelessWidget {
  const HomeRoute({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Welcome'),
        backgroundColor: Colors.green,
      ),

      body: Center(



        child: Column(

          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            Image.asset('assets/image/fine.jpg',height: 400,width: 400,),


            ElevatedButton(
              child: const Text('Join Us'),
              onPressed: () {
                Navigator.pushNamed(context, '/second');
              },
            ), // ElevatedButton
            ElevatedButton(
              child: const Text('Login'),
              onPressed: () {
                Navigator.pushNamed(context, '/third');
              },
            ), // ElevatedButton
          ], // <Widget>[]
        ), // Column
      ), // Center
    ); // Scaffold
  }
}

class SecondRoute extends StatelessWidget {
  const SecondRoute({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text("Join Page"),
        backgroundColor: Colors.green,
      ), // AppBar
      body: Center(
        child: ElevatedButton(
          onPressed: () {
            Navigator.pop(context);
          },
          child: const Text('Back!'),
        ), // ElevatedButton
      ), // Center
    ); // Scaffold
  }
}

class ThirdRoute extends StatelessWidget {
  const ThirdRoute({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text("Let's get to Know Each Other",style: TextStyle(fontSize: 25,color: Colors.black,fontWeight: FontWeight.bold),),

        backgroundColor: Colors.white,
        centerTitle: true,
      ), // AppBar

      body: Column(

        mainAxisAlignment: MainAxisAlignment.center,
        crossAxisAlignment: CrossAxisAlignment.center,
        children: [
          Text('We need this information to create your Mohur account',style: TextStyle(fontSize:20,color: Colors.black,
               ),
          ),



          Padding(
            padding: const EdgeInsets. symmetric(vertical: 30),
            child: Form(child: Column(
              children: [



                Padding(
                  padding: const EdgeInsets.symmetric(horizontal: 15),
                  child: TextFormField(keyboardType: TextInputType.emailAddress,
                    decoration: InputDecoration(labelText: 'First Name',hintText: 'Type First Name',
                      prefixIcon: Icon(Icons.email),border: OutlineInputBorder(borderSide: BorderSide(color: Colors.red),borderRadius: BorderRadius.all(Radius.circular(9.0))),

                    ),
                    onChanged: (String value){


                    },
                    validator: (value){
                      return value!.isEmpty ? 'Please Enter First Name':null;
                    },
                  ),
                ),
                SizedBox(height: 30,),
                Padding(
                  padding: const EdgeInsets.symmetric(horizontal: 15),
                  child: TextFormField(keyboardType: TextInputType.emailAddress,
                    decoration: InputDecoration(labelText: 'Second Name',hintText: 'Type Second Name',
                      prefixIcon: Icon(Icons.email),border: OutlineInputBorder(borderSide: BorderSide(color: Colors.red),borderRadius: BorderRadius.all(Radius.circular(9.0))),
                    ),
                    onChanged: (String value){

                    },
                    validator: (value){
                      return value!.isEmpty ? 'Please Enter Second Name':null;
                    },
                  ),
                ),
                SizedBox(height: 30,),



                Padding(
                  padding: const EdgeInsets.symmetric(horizontal: 15),
                  child: TextFormField(keyboardType: TextInputType.emailAddress,
                    decoration: InputDecoration(labelText: 'Email',hintText: 'Type Email',
                  prefixIcon: Icon(Icons.email),border: OutlineInputBorder(borderSide: BorderSide(color: Colors.red),borderRadius: BorderRadius.all(Radius.circular(9.0))),
                  ),
                    onChanged: (String value){

                    },
                    validator: (value){
                    return value!.isEmpty ? 'Please Enter email':null;
                    },
                  ),
                ),
                SizedBox(height: 30,),
                Padding(
                  padding: const EdgeInsets.symmetric(horizontal: 15),
                  child: TextFormField(keyboardType: TextInputType.visiblePassword,
                    decoration: InputDecoration(labelText: 'Password',hintText: ' password',
                      prefixIcon: Icon(Icons.password),border: OutlineInputBorder(borderSide: BorderSide(color: Colors.red),borderRadius: BorderRadius.all(Radius.circular(9.0))),
                    ),
                    onChanged: (String value){

                    },
                    validator: (value){
                      return value!.isEmpty ? 'Please Enter Password':null;
                    },
                  ),
                ),
                SizedBox(height: 30,),
                Padding(
                  padding: const EdgeInsets.symmetric(horizontal: 15),
                  child: TextFormField(keyboardType: TextInputType.visiblePassword,
                    decoration: InputDecoration(labelText: 'Confirm Password',hintText: 'Type Confirm Password',
                      prefixIcon: Icon(Icons.password),border: OutlineInputBorder(borderSide: BorderSide(color: Colors.red),borderRadius: BorderRadius.all(Radius.circular(9.0))),
                    ),
                    onChanged: (String value){

                    },
                    validator: (value){
                      return value!.isEmpty ? 'Please Enter Password':null;
                    },
                  ),
                ),
                SizedBox(height: 30,),
                Padding(
                  padding: const EdgeInsets.symmetric(horizontal: 35),
                  child: MaterialButton(
                    minWidth: double.infinity,onPressed: (){},
                  child: Text('Login'),color: Colors.teal,textColor: Colors.white,),
                )
              ],

            ),
            ),
          ),
        ],

      ),
    ); // Scaffold
  }
}
