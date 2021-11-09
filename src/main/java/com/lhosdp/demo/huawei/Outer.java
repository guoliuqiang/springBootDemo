package com.lhosdp.demo.huawei;

/**
 * . public class Outer{
 * 2. public void someOuterMethod() {
 * 3. // Line 3
 * 4. }
 * 5. public class Inner{}
 * 6. public static void main( String[]argv ) {
 * 7. Outer o = new Outer();
 * 8. // Line 8
 * 9. }
 * 10. }
 *
 * Which instantiates an instance of Inner?
 * A. new Inner(); // At line 3
 * B. new Inner(); // At line 8
 * C. new o.Inner(); // At line 8
 * D. new Outer.Inner(); // At line 8//new Outer().new Inner()
 */
public class Outer {
    public void someOuterMethod(){
        new Inner();
    }

    public class Inner{}

    public static void main(String[] args) {
        Outer outer = new Outer();
    }
}

/**
 * 答案是A
 *
 * 我以为两行都要选 所以选了A D
 * 排除C o不能解释为一种类型
 * 排除B D  Inner不是静态的 报错 'com.lhosdp.demo.huawei.Outer.this' cannot be referenced from a static context 不能从静态上下文中引用
 */
