import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter WS_Day1',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: const MyHomePage(title: 'Flutter WS_Day1'),
    );
  }
}

class MyHomePage extends StatefulWidget {
  const MyHomePage({Key? key, required this.title}) : super(key: key);

  final String title;

  @override
  State<MyHomePage> createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {

  String _text = "SSAFY";
  void _pressElevatedButton(){
      setState(() {
        _text="구미 6반 만세~";

      });
  }

  void _pressFloatingActionButton(){
    setState(() {
      _text="SSAFY \n Mobile Track 파이팅 ~~";
    });
  }

  @override
  Widget build(BuildContext context) {

    return Scaffold(
      appBar: AppBar(
        title: Text(widget.title),
      ),
      body: Center(

        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            Text(
                _text,
                style: TextStyle(
                  color: Colors.orange,
                  fontSize: 30,
                ),
            ),
            ElevatedButton(onPressed: _pressElevatedButton, child: const Icon(
              Icons.print,
            )),
          ],
        ),
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: _pressFloatingActionButton,
        child: const Icon(Icons.touch_app),
      ), // This trailing comma makes auto-formatting nicer for build methods.
    );
  }
}
