package cn.xingzhiwei.upms.bean.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Created by HF on 2018/2/5.
 */
@Profile({"dev","local"})
@Component
@ConfigurationProperties(prefix = "book")
@PropertySource(value = "classpath:/property/book.properties",encoding = "UTF-8")
public class BookConfig {

    private String name;

    private String author;

    private Integer size;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}
