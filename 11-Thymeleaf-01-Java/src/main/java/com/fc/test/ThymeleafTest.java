package com.fc.test;

import org.junit.Test;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;


//测试非web环境使用的thymeleaf
public class ThymeleafTest {
    @Test
    public  void  testRenderStaticData(){
        //创建一个模板引擎
        TemplateEngine engine = new TemplateEngine();
        //准备一个模板
        //th.value是模板引擎所支持的标签属性
        //能够被thymeleaf所识别
        //被th.value标签的内容就是我们刚刚提到的占位符
        //可以给占位符传递参数并进行替换
        //替换后的效果和value属性是一样的
        String  template = "<input type='text' th.value='666'>";
        //准备一个环境上下文对象
        Context context = new Context();
        // 使用模板引擎去处理模板（渲染）
        // 获取处理好（渲染好）的页面
        String html =engine.process(template,context);
        System.out.println(html);
    }
    //测试动态数据
    @Test
    public  void  testRenderDynamicData(){
        //还是先创建一个模板引擎
        TemplateEngine engine = new TemplateEngine();
        //创建模板
        // 准备一个模板(动态模板)
        // 注意，把静态的数据使用${}的方式变成动态的占位符，等会可以传递参数
        // 外面的th:value就能被模板引擎所识别，并替换了
        // 这个${}和jsp中的EL表达式一模一样
        String con = "<input type='text' th:value=${value}>";
        //创建上下文呢
        Context context = new Context();
        //传递
        context.setVariable("value",888);
        String html = engine.process(con,context);
        System.out.println(html);
    }
    //直接渲染一个html页面
    @Test
    public  void  testRenderHtml(){
        //创建一个模板
        TemplateEngine engine = new TemplateEngine();
        // 这个时候我们不需要准备模板了，但是需要加载html
        // 所以我们需要准备一个html的解析器
        // 这个解析器就能够解析html页面了
        //因为要访问html页面所以不需要创建模板了，而是想办法去html页面
        ClassLoaderTemplateResolver resolver = new ClassLoaderTemplateResolver();
        //设置解析器
        engine.setTemplateResolver(resolver);
        //环境上下文
        Context context = new Context();
        context.setVariable("name",9455355);
        //直接传递路径和环境上下文对象
        String html = engine.process("index.html",context);
        System.out.println(html);
    }
    // 如果我们有很多公共的前后缀时可以通过这种方式来手动设置前后缀
    @Test
    public void testPrefixAndSuffix() {
        //创建一个模板引擎对象
        TemplateEngine engine = new TemplateEngine();
        //准备一个解析器
        ClassLoaderTemplateResolver resolver = new ClassLoaderTemplateResolver();
        //设置前后缀
        resolver.setPrefix("templates/");
        resolver.setSuffix(".html");
        //设置解析器
        engine.setTemplateResolver(resolver);
        //环境上下文呢
        Context context = new Context();
        context.setVariable("name",489);
        String html = engine.process("main",context);
        System.out.println(html);
    }
}
