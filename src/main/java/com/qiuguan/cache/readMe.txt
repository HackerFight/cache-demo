如果不想再去新建处理器，而是使用事务，AspectJ, 缓存这些通用的处理器
则需要有一个增强器Advisor, 且这个增强器交给spring管理，并且角色是：@Role(BeanDefinition.ROLE_INFRASTRUCTURE)

AOP中几个重要角色
  Advisor : 增强器
    Advice: 通知，就是拦截器
    PointCut: 切入点
        ClassFilter ： 会优先过滤类，帅选出候选的类
        MethodMatcher:  过滤方法，判断是否有类似 @Cacheable 注解

经过 ClassFilter 和 MethodMatcher 过滤之后还符合的，那就是需要代理的bean


当实际调用方法的时候 MethodMatcher 还会工作，因为它要判断你当前调用的方法是否真的需要增强
如果就是一个普通方法，则只需要通过反射调用目标方法即可，不需要再去经过复杂的通知过程


我这里就是说明创建AOP的过程，对于缓存逻辑有点复杂，暂时就不写了