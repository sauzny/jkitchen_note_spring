package com.sauzny.springboot.springutil.beancopier;

import java.time.LocalDateTime;

import org.springframework.cglib.beans.BeanCopier;
import org.springframework.cglib.core.Converter;

public final class ProductBeanCopier {

    // BeanCopier 不使用自定义的转换器
    static BeanCopier copier1 = BeanCopier.create(Product.class, ProductVO.class, false);

    // BeanCopier 使用自定义的转换器
    static BeanCopier copier2 = BeanCopier.create(Product.class, ProductVO.class, true);
    static ProductConverter converter = new ProductConverter();
    
    private ProductBeanCopier(){}
    
    public static void productToProductVO1(Product product, ProductVO productVO){
        copier1.copy(product, productVO, null);
    }
    
    public static void productToProductVO2(Product product, ProductVO productVO){
        copier2.copy(product, productVO, converter);
    }
    
    public static void main(String[] args) {

        Product product = new Product();
        product.setId(9869879L);
        product.setName("name");
        product.setSupplierProductNo("SupplierProductNo");
        product.setSupplierName("SupplierName");
        product.setPurchasePrice(123324);
        product.setMinDistribution(8172638);
        product.setMaxDistribution(12425345);
        product.setCreateTime(LocalDateTime.now());
        product.setLastUpdateTime(LocalDateTime.now());
        
        ProductVO beanCopierResult1 = new ProductVO();
        ProductBeanCopier.productToProductVO1(product, beanCopierResult1);
        System.out.println(beanCopierResult1);
        

        ProductVO beanCopierResult2 = new ProductVO();
        ProductBeanCopier.productToProductVO2(product, beanCopierResult2);
        System.out.println(beanCopierResult2);
    }
}

class ProductConverter implements Converter {  
  
    @SuppressWarnings("rawtypes")  
    @Override  
    public Object convert(Object value, Class target, Object context) { 
        
        // 并不是原对象的所有属性都会进入此方法
        // 原对象与目标对象的属性名称一致的时候，此属性才会进入此方法
        
        // 原值
        System.out.println(value);
        // 目标类型
        System.out.println(target);
        // String型的方法名字 如 "setSupplierName"
        System.out.println(context);
        
        if (value instanceof LocalDateTime) {  
            LocalDateTime ldt = (LocalDateTime) value;  
            return ldt.toString().replace("T", " ");
        }
        
        // 使用过滤器时，会过滤所有的值，所以要在此方法中考虑所有的值
        return value;  
    }  
}  

