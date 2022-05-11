import 'dart:math';

class Position{
  int x = 0;
  int y = 0;

  double distanceTo(Position other){
    double answer = sqrt(pow(other.x,2)+pow(other.y,2));
    return answer;
  }
}

class Square{
  int width = 0;
  int height = 0;
  Square(this.width, this.height);

  int getArea(){
    return width * height;
  }
}

class CalcSquare extends Square with Position {

  CalcSquare(int width, int height) : super(width, height);

}