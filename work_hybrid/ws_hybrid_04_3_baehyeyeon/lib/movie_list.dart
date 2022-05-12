import 'package:flutter/material.dart';
import 'package:ws_hybrid_04_3_jeongsanghoon/movie.dart';
import 'package:ws_hybrid_04_3_jeongsanghoon/movie_detail.dart';
import 'http_helper.dart';

class MovieList extends StatefulWidget {
  const MovieList({Key? key}) : super(key: key);

  @override
  _MovieListState createState() => _MovieListState();
}

class _MovieListState extends State<MovieList> {
  final String _iconBase = 'https://image.tmdb.org/t/p/w92/';
  final String _defaultImage = 'https://images.freeimages.com/images/large-previews/5eb/movie-clapboard-1184339.jpg';

  final HttpHelper _helper = HttpHelper();
  List<Movie> _movies = [];

  @override
  void initState() {
    _initialize();
    super.initState();
  }

  Future<void> _initialize() async {
    // HttpHelper 클래스의 getUpcoming() 함수를 호출하여 최근 영화 정보를 가져온다.
    // 구현 ------------------------
    HttpHelper httpHelper = HttpHelper();
    Future<List<Movie>> listMovie = httpHelper.getUpcoming();
    _movies = [];

    setState(() {
      // var dataConvertedToJSON = json.decode(listMovie);
      // List result = dataConvertedToJSON['documents'];
      // _movies.addAll(result);
    });
  }

  @override
  Widget build(BuildContext context) {
    var itemCount = _movies.length;
    
    return Scaffold(
        appBar: AppBar(title: const Text('SSAFY Movie')),
        body: ListView.builder(
            itemCount: itemCount,
            itemBuilder: (BuildContext context, int position) {

              String? posterPath = _movies[position].posterPath;
              String imageUrl = posterPath != null ? _iconBase + posterPath : _defaultImage;

              NetworkImage image = NetworkImage(imageUrl);
              String title = _movies[position].title ?? "(제목없음)";
              String releaseDate = _movies[position].releaseDate ?? "(미정)";
              String vote = (_movies[position].voteAverage ?? 0).toString();

              return Card(
                  color: Colors.white,
                  elevation: 2.0,
                  // ListTile에 CircleAvatar, Text(title), Text(출시일, 평점), onTap에는 상세 페이지 이동 구현
                  child: ListTile(
                    // 리스트에 보여지는 코드를 구현하세요 ~~~~
                    leading: CircleAvatar(
                      radius: 30.0,
                      backgroundImage: image,
                    ),
                    title: Text(title),
                    subtitle: Text(
                      "Released: $releaseDate - Vote: $vote"
                    ),
                  )
              );
            })
    );
  }
}
