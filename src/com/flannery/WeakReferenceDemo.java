package com.flannery;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;

// https://blog.csdn.net/csdn_20150804/article/details/103748869
public class WeakReferenceDemo {

    public static void main(String[] args) {
        // extracted(); // 第一个demo
        extracted2();
    }

    // 执行前后，我们都打印了引用队列种的内容，GC之前没有打印输出；GC之后，弱引用被放入队列中，被打印输出。
    private static void extracted2() {
        ReferenceQueue<RoleDTO> referenceQueue = new ReferenceQueue<>();
        WeakReference<RoleDTO> weakReference =
                new WeakReference(new RoleDTO(1, "CFO"), referenceQueue);

        System.out.println("CG执行前---");
        Reference<? extends  RoleDTO> reference;
        while ((reference = referenceQueue.poll()) != null) {
            System.out.println("referenceQueue中：" + reference);
        }

        System.gc();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("GC执行后.....");
        if (weakReference.get()==null) {
            System.out.println("弱引用对象已经被回收");
        }
        Reference<? extends RoleDTO> reference2;
        while ((reference2 = referenceQueue.poll()) != null){
            System.out.println("referenceQueeu中:"+reference2);
        }
    }

    private static void extracted() {
        // 强引用
        RoleDTO role = new RoleDTO(1, "CEO");

        // 弱引用
        WeakReference<RoleDTO> weakReferenceDemo =
                new WeakReference(new RoleDTO(1, "CTO"));
        // 主动gc
        System.gc();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (role == null) {
            System.out.println("强引用对象已经被回收");
        }
        if (weakReferenceDemo.get() == null) {
            System.out.println("弱引用已经被回收");
        }
    }

}

//随便创建个对象
//import lombok.Data;
class RoleDTO {
    private Integer id;
    private String type;

    public RoleDTO(Integer id, String type) {
        this.id = id;
        this.type = type;
    }
}
