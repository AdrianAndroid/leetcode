package com.flannery;

import java.util.Optional;

public class main {

    static class MyUser {
        final String id;
        final String username;

        MyUser(String id, String username) {
            this.id = id;
            this.username = username;
        }

        public String getId() {
            return id;
        }

        public String getUsername() {
            return username;
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");

        //// 4.1 构建
        // 返回一个描述给定值的Optional, 如果不为null，则返回一个空的Optional
        // 参数：值-描述的可能为null值
        // 类型参数：《T》-值的类型
        // 返回值：一个Optional与如果指定值是非当前值null，否则一个空Optional
        Optional s1 = Optional.ofNullable(null);

        // 构建一个value不可以为null的optinal对象，如果of()的入参为null会报空指针异常
        Optional<MyUser> s2 = Optional.of(new MyUser("阿辉2", "123456"));

        // 构建一个value可以为null的optional对象
        Optional<MyUser> s3 = Optional.ofNullable(null);

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println("==========================");
        System.out.println("==========================");
        //// 判断类
        Optional<MyUser> myUser1 = Optional.empty();
        Optional<MyUser> myUser2 = Optional.of(new MyUser("阿飞", "123456"));
        // filter传入一个lambda，lambda返回值为boolean，true：不做任何改变 false：返回一个空optional
        Optional<MyUser> myUser3 = myUser2.filter(user -> " 错误的密码".equals(user.username));
        // isPresent就是判断value是不是null；我们在调用get之前，一定要先调用isPresent
        // 因为如果直接返回value是null，直接调用get会报异常
        if (myUser1.isPresent()) {
            MyUser value = myUser1.get();
            System.out.println("optional value:" + value);
        } else {
            System.out.println("optional value == null");
        }
        // ifPresent传入一段lambda，当value!=null时候，执行里面的逻辑；
        // 当value==null时，啥都不干
        myUser2.ifPresent(value -> System.out.println("optional value : " + value));

        System.out.println(myUser3);

        System.out.println("==========================");
        System.out.println("==========================");
        //// 4.3 判断类
        Optional<MyUser> userInfoEmptyOpt = Optional.empty();
        Optional<MyUser> userInfoOpt = Optional.of(new MyUser("阿飞", "123456"));
        // 1. 直接获取，注意如果value==null,会报NoSuchElementException异常
        MyUser userInfo1 = userInfoOpt.get();
        // 2. orElse可以传入一个UserInfo类型的对象作为默认值；
        // 当value!=null时，返回value值；当value==null时，返回默认值作为代替
        MyUser userInfo2 = userInfoEmptyOpt.orElse(new MyUser("阿飞1", "123456"));
        // 3. orElseGet和orElse不同的是orElseGet可以传入一段lambda表达式
        // 当value!=null时，返回value值
        // 当value==null时，使用该lambda返沪的对象作为默认值
        MyUser userInfo3 = userInfoEmptyOpt.orElseGet(() -> new MyUser("阿飞2", "123456"));
        // 4. orElseThrow可以传入一段lambda表达式，lambda返回一个Exception；
        // 当value！=null时，返回value值
        // 当value==null时，抛出异常
        MyUser userInfo4 = userInfoOpt.orElseThrow(NullPointerException::new);
        System.out.println(userInfo1);
        System.out.println(userInfo2);
        System.out.println(userInfo3);
        System.out.println(userInfo4);

        System.out.println("==========================");
        System.out.println("==========================");
        //// 4.2转换类
        /*Optional<MyUser> */
        userInfoOpt = Optional.of(new MyUser("阿飞", "123456"));
        // 原来value的类型是UserInfo， 经过map转换为Optional<String>
        Optional<String> username = userInfoOpt.map(MyUser::getId);
        // 当map的如参也是一个Optional时， 经过map转化后会形成Optional<Optional<String>>这种嵌套结构
        // 但flatMap可以将嵌套结构打平
        Optional<Optional<String>> unFlatMap = userInfoOpt.map(user -> Optional.of(user.getId()));
        Optional<String> flatMap = userInfoOpt.flatMap(user -> Optional.of(user.getId()));
        System.out.println(username);
        System.out.println(unFlatMap);
        System.out.println(flatMap);
    }

}
