import 'dart:convert';
import 'dart:io';
import 'package:http/http.dart' as http;
import 'package:ws_hybrid_04_3_jeongsanghoon/movie.dart';

class HttpHelper {
  final String _urlBase = 'https://api.themoviedb.org/3/movie';
  final String _urlUpcoming = '/upcoming?';
  final String _urlKey = 'api_key=53a017261b8c9cff544b7d8ef7b40a11';
  final String _urlLanguage = '&language=ko-KR';

  Future<List<Movie>> getUpcoming() async {
    final String upcoming = _urlBase + _urlUpcoming + _urlKey + _urlLanguage;
    // http.get 함수를 이용하여 영화정보를 받고 전달된 JSON 타입의 결과를
    // 리스트 형태로 변환하여 리턴한다.
    // 코드 구현 --------------------------------
    var response = await http.get(Uri.parse(upcoming));
    print(response.body);
    if (response.statusCode == 200) {
      // 만약 서버가 OK 응답을 반환하면, JSON을 파싱합니다.
      //return Post.fromJson(json.decode(response.body));
      print('예');
    } else {
      // 만약 응답이 OK가 아니면, 에러를 던집니다.
      //throw Exception('Failed to load post');
      print('아니오');
    }

    return [];
  }

}
