import 'package:flutter/material.dart';
import 'package:ws_hybrid_03_3_baehyeyeon/shape.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: const MyHomePage(title: 'Flutter WS_Day3'),
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
  final _textCtrl1 = TextEditingController();
  final _textCtrl2 = TextEditingController();

  String _result = "결과값 :";



  @override
  void dispose() {
    _textCtrl1.dispose();
    _textCtrl2.dispose();
    super.dispose();
  }
  
  void _calculation(int x, int y) {
    CalcSquare calcSquare =CalcSquare(x, y);
    Position position = Position();
    position.x = x;
    position.y = y;
    double distance = calcSquare.distanceTo(position);
    int area = calcSquare.getArea();
    setState(() {
      _result = '연산 결과 x=$x, y=$y \n 거리 $distance, \n 넓이 : $area';
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
            const Text(
                '거리 & 사각형 면적 계산하기',
                style: TextStyle(
                    fontSize: 25
                )
            ),
            TextField(
              controller: _textCtrl1,
            ),
            TextField(
              controller: _textCtrl2,
            ),
            Text(
                _result,
                style: const TextStyle(
                    fontSize: 15
                )
            ),
          ],
        ),
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: () {
          int x = int.parse(_textCtrl1.text);
          int y = int.parse(_textCtrl2.text);
          _calculation(x, y);
        },
        tooltip: 'Increment',
        child: const Icon(
          Icons.calculate,
        ),
      ), // This trailing comma makes auto-formatting nicer for build methods.
    );
  }
}

