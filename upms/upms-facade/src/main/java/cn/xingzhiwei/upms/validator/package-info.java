/**
 * <pre>
 * spring 实体校验
 * spring Validator 实现 和 JSR303 Bean Validation
 * </pre>
 *
 * <pre> 一、spring Validator 实现 </pre>
 *
 * <pre>校验工具类
 *  ValidationUtils
 *  ValidationUtils.rejectIfEmpty(errors, "userName", "user.userName.required", "用户名不能为空");
 *  </pre>
 *
 * <pre>
 * package org.springframework.validation;
 *  public interface Validator {
 *      boolean supports(Class<?> clazz);
 *      void validate(Object target, Errors errors);
 * }
 * </pre>
 *
 * 使用：设置Validator，并触发校验
 * 1.  在我们的Controller中需要使用父类已有的方法来为DataBinder对象指定Validator，
 * protected initBinder(WebDataBinder binder); 代码如下：
 * <pre>@InitBinder
 *     protected void initBinder(WebDataBinder binder){
 *      binder.setValidator(new UserValidator());
 *     }
 * </pre>
 * 2.  为binder对象指定好Validator校验对象后，
 *      下面一步的就是在需要校验的时候触发validate方法，该触发步骤是通过 @Validated 注解（该注解是Spring框架定义的）实现的。
 *
 * <pre>处理提交的用户注册信息。
 * import org.springframework.validation.annotation.Validated;
 *
 * <pre>@RequestMapping (method = RequestMethod.POST)</pre>
 * <pre>public String doRegister(@Validated User user, BindingResult result){</pre>
 *         if(logger.isDebugEnabled()){
 *         logger.debug("process url[/user], method[post] in "+getClass());
 *         }
 *         //校验没有通过
 *         if(result.hasErrors()){
 *         return "user";
 *         }
 *
 *         if(user != null){
 *         userService.saveUser(user);
 *         }
 *
 *         return "user";
 *         }
 * </pre>
 *
 * <pre> 二、 JSR303 Bean Validation </pre>
 *
 * <pre>
 * //调用JSR303验证工具，校验参数
 *  Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
 *  Set<ConstraintViolation<ValidateTestClass>> violations = validator.validate(this);
 *  Iterator<ConstraintViolation<ValidateTestClass>> iter = violations.iterator();
 *  if (iter.hasNext()) {
 *  String errMessage = iter.next().getMessage();
 *  throw new ValidationException(errMessage);
 *  }
 * </pre>
 *
 * 1） 校验属性的Constraints的设定。
 * 该步骤就是对要校验的对象的属性，使用已经定义的Constraints对需要校验的属性进行约束。在JSR303中已经定义的Constraint如下：
 * <pre>
 *     表 1. Bean Validation 规范内嵌的约束注解定义
 *     约束注解名称  约束注解说明
 *     <pre> @Null           验证对象是否为空</pre>
 *     <pre> @NotNull    验证对象是否为非空</pre>
 *     <pre> @AssertTrue     验证 Boolean 对象是否为 true</pre>
 *     <pre> @AssertFalse    验证 Boolean 对象是否为 false</pre>
 *     <pre> @Min            验证 Number 和 String 对象是否大等于指定的值</pre>
 *     <pre> @Max            验证 Number 和 String 对象是否小等于指定的值</pre>
 *     <pre> @DecimalMin     验证 Number 和 String 对象是否大等于指定的值，小数存在精度</pre>
 *     <pre> @DecimalMax     验证 Number 和 String 对象是否小等于指定的值，小数存在精度</pre>
 *     <pre> @Size           验证对象（Array,Collection,Map,String）长度是否在给定的范围之内</pre>
 *     <pre> @Digits     验证 Number 和 String 的构成是否合法</pre>
 *     <pre> @Past           验证 Date 和 Calendar 对象是否在当前时间之前</pre>
 *     <pre> @Future     验证 Date 和 Calendar 对象是否在当前时间之后</pre>
 *     <pre> @Pattern    验证 String 对象是否符合正则表达式的规则</pre>
 * </pre>
 *
 * 2） Validate的触发
 * 在需要校验的对象前增加 @Valid 注解 （该注解位于javax.validation包中）来触发校验。示例如下：
 * <pre>
 *      <pre>@RequestMapping (method = RequestMethod.POST)</pre>
 *      <pre>public String doRegister(@Valid User user, BindingResult result){</pre>
 *          if(logger.isDebugEnabled()){
 *              logger.debug("process url[/user], method[post] in "+getClass());
 *          }
 *          //校验没有通过
 *          if(result.hasErrors()){
 *              return "user";
 *          }
 *
 *          if(user != null){
 *              userService.saveUser(user);
 *          }
 *
 *          return "user";
 *      }
 * </pre>
 *
 * <pre>
 * 注： 想要往页面传数据的时候，不要调用result.getModel().put(key, value);
 * 这样做将不起作用，因为getModel()方法每次都是生成一个新的，保存的东西就会丢失。
 * 最好在响应方法中加一个： Map<String, Object> map来保存数据
 * </pre>
 *
 * Created by rain on 2018/2/18.
 */
package cn.xingzhiwei.upms.validator;