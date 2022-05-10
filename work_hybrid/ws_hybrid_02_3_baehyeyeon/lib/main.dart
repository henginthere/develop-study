import 'dart:convert';
import 'dart:io';


void main() {
  File('files/sample_input.txt').readAsString().then((String contents) {
    var lineSplitter = LineSplitter();
    var lines = lineSplitter.convert(contents);
    var it = lines.iterator;

    it.moveNext();
    var T = int.parse(it.current);
    it.moveNext();
    for (int testCase = 1; testCase <= T; testCase++) {
      stdout.write('#$testCase ');

      // 알고리즘 코드 작성
      var solution = Solution();
      solution.run(it);
    }
  });
}
class WaterStrider {
  int x = 0;
  int y = 0;
  int dir = 0;

  WaterStrider(this.x, this.y, this.dir);

}
class Solution {
  int _N = 0;
  int _num = 0;

  var dx = [-1,1,0,0];
  var dy = [0,0,-1,1];

  void run(Iterator<String> it) {
    _N = int.parse(it.current.split(" ")[0]);
    _num = int.parse(it.current.split(" ")[1]);
    it.moveNext();

    var visited = List.generate(_N, (index) => List.filled(_N, 0)); //이차원 배열
    var waterStriders = List.generate(_N, (index) => WaterStrider(0, 0, 0));

    for(int i=0;i<_num;i++){
      int x = int.parse(it.current.split(" ")[0]);
      int y = int.parse(it.current.split(" ")[1]);
      int dir = int.parse(it.current.split(" ")[2]);
      //stdout.write('$x $y $dir');
      visited[x][y]=1; //그 위치에 소금쟁이 있으면 1
      waterStriders[i] = WaterStrider(x, y, dir);
      it.moveNext();
    }

    int count = _num;
    for (int i=0;i<_num;i++) {
        WaterStrider tmp = waterStriders[i];
        //stdout.write('${tmp.x}');
        int dirX = dx[tmp.dir-1];
        int dirY = dy[tmp.dir-1];

        int curX = tmp.x;
        int curY = tmp.y;

        visited[curX][curY]=0;

        for(int jump=3;jump>0;jump--){
          curX += dirX * jump;
          curY += dirY * jump;
          if(curX<0||curX>=_N||curY<0||curY>=_N||visited[curX][curY]==1){
            count--;
            break;
          }

          if(jump==1){
            if(visited[curX][curY]==1) {
              count--;
            } else {
              visited[curX][curY]=1;
            }
          }

        }
    }

    stdout.write('$count \n');

  }

}