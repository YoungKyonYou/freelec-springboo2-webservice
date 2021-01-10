package com.jojoldu.book.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class IndexControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void 메인페이지_로딩(){
        String body=this.restTemplate.getForObject("/",String.class);

        assertThat(body).contains("스프링 부트로 시작하는 웹 서비스");
    }

    @Test
    public void 게시글등록_로딩(){
        String body=this.restTemplate.getForObject("/posts/save",String.class);
        assertThat(body).contains("게시글 등록");//이러한 문자열이 url에 있나 없나 확인하는 것인
        //추가적으로 확인할 수 있다.
    }
}
