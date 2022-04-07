package com.ssafy.userinterface_3

import android.util.Xml
import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserException
import java.io.IOException
import java.io.InputStream

data class Member(var name: String) {
    val phone: MutableMap<String, String> = mutableMapOf()
}

private const val TAG = "MyAddressParser_싸피"
class MyAddressParser {

    // namespace: 문서에는 없지만 api에서 계속 사용
    private val ns: String? = null

    @Throws(XmlPullParserException::class, IOException::class)
    fun parse(inputStream: InputStream): List<Member> {
        inputStream.use {
            val parser = Xml.newPullParser()

            // 파서 내에서 namespace를 사용하지 않겠다고 설정
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false)
            parser.setInput(inputStream, "UTF-8")

            // 내부적으로 next()를 호출하고 START_TAG나 END_TAG를 만나면 event 발생,
            // 만약 문제 발생 시 XmlPullParserException 발생
            parser.nextTag()
            return readAddress(parser)
        }
    }

    @Throws(XmlPullParserException::class, IOException::class)
    fun readAddress(parser: XmlPullParser): List<Member> {
        val addresses = mutableListOf<Member>()

        // 현재의 이벤트가 "주소록"이라는 태그의 시작점이라면.
        parser.require(XmlPullParser.START_TAG, ns, "주소록")

        // 다음 이벤트가 END_TAG가 아닐 때까지 읽어들임. 찾는 내용은 회원이라는 태그를 읽은 시점(시작)
        while (parser.next() != XmlPullParser.END_TAG) {

            // START_TAG가 아니면 다음 이벤트로 이동
            if (parser.eventType != XmlPullParser.START_TAG) {
                continue
            }

            when (parser.name) {
                // 태그의 이름이 회원이면 상세 회원 정보 획득을 위해 파싱 진행
                "회원" -> addresses.add(readMember(parser))
                else -> skip(parser)  // 혹시 다른 태그라면 생략
            }
        }

        return addresses
    }

    @Throws(XmlPullParserException::class, IOException::class)
    fun readMember(parser: XmlPullParser): Member {
        var member: Member? = null

        // 이제 회원 태그가 시작 태그
        parser.require(XmlPullParser.START_TAG, ns, "회원")

        // 다음으로 읽은 태그가 닫는 태그가 아닐 때까지 반복
        while (parser.next() != XmlPullParser.END_TAG) {
            if (parser.eventType != XmlPullParser.START_TAG) {
                continue
            }

            when (parser.name) {
                "name" -> member = Member(readName(parser))
                "phone" -> readPhone(parser, member!!)
                else -> skip(parser)
            }
        }
        return member!!
    }

    @Throws(IOException::class, XmlPullParserException::class)
    private fun readName(parser: XmlPullParser): String {
        parser.require(XmlPullParser.START_TAG, ns, "name")
        val tagTextValue = readText(parser)
        parser.require(XmlPullParser.END_TAG, ns, "name")
        return tagTextValue
    }

    @Throws(IOException::class, XmlPullParserException::class)
    private fun readPhone(parser: XmlPullParser, member: Member) {
        // 시작 태그는 phone으로
        parser.require(XmlPullParser.START_TAG, ns, "phone")

        // xml은 순서대로 읽기 때문에 type을 먼저 읽고 text 처리
        val type = parser.getAttributeValue(null, "type")

        val phoneNumber = readText(parser)
        member.phone[type] = phoneNumber
        parser.require(XmlPullParser.END_TAG, ns, "phone")
    }

    // 태그에서 text만 추출해내기
    @Throws(IOException::class, XmlPullParserException::class)
    private fun readText(parser: XmlPullParser): String {
        var result = ""
        if (parser.next() == XmlPullParser.TEXT) {
            result = parser.text
            parser.nextTag()
        }
        return result
    }

    //
    @Throws(XmlPullParserException::class, IOException::class)
    private fun skip(parser: XmlPullParser) {
        // START_TAG가 아닌 경우 예외 발생
        if (parser.eventType != XmlPullParser.START_TAG) {
            throw IllegalStateException()
        }
        // 하위로 중첩된 태그의 처리를 위해서 flag로 depth 사용
        var depth = 1
        while (depth != 0) {
            when (parser.next()) {
                XmlPullParser.END_TAG -> depth--
                XmlPullParser.START_TAG -> depth++
            }
        }
    }
}