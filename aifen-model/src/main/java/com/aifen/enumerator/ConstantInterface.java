package com.aifen.enumerator;


/**
 * @Title ConstantInterface
 * @Author     qierkang xyqierkang@163.com
 * @Date       Created in 2019-03-30 22:07
 * @Description [ 公共枚举 ]
 */
public interface ConstantInterface {

    /**
     * @author qierkang
     * @ClassName: Enum
     * @date 2016年5月31日
     * @Description: (枚举)
     */
    interface Enum {

        enum ResultEnum {
            result_000000("000000", "操作成功"),
            result_100000("100000", "该属性不能为空"),
            result_899995("899995", "token无效"),
            result_899996("899996", "token已过期"),
            result_899997("899997", "token时间戳无效"),
            result_899998("899998", "解密失败,token可能遭到篡改"),
            result_899999("899999", "token为空,请检查登录状态"),
            result_900000("900000", "登录失效,请重新登录"),
            result_910000("910000", "用户名或密码错误"),
            result_910001("910001", "用户名不存在"),
            result_910002("910002", "密码错误"),
            result_910003("910003", "用户未启用"),
            result_910004("91 0004", "用户名已被使用"),
            result_988888("988888", "无权限访问"),
            result_999999("999999", "系统错误，请联系管理员"),
            result_failed("400001", "faceId认证流程未完成或出现异常"),
            result_cancelled("400002", "faceId认证取消"),
            result_timeout("400003", "faceId认证超时"),
            result_score_low("400004", "人脸识别分数过低");

            private String key;
            private String value;

            public String getKey() {
                return key;
            }

            public void setKey(String key) {
                this.key = key;
            }

            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }

            ResultEnum(String key, String value) {
                this.key = key;
                this.value = value;
            }
        }

        /**
         * @author qierkang
         * @ClassName: ConstantNumber
         * @date 2016年5月19日
         * @Description: (整数枚举)
         */
        enum ConstantNumber {
            /**
             * @Fields NEGATIVE : ( -1 )
             */
            NEGATIVE(-1),
            /**
             * @Fields ZERO : ( 0 )
             */
            ZERO(0),
            /**
             * @Fields ONE : ( 1 )
             */
            ONE(1),
            /**
             * @Fields TOW : ( 2 )
             */
            TOW(2),
            /**
             * @Fields THREE : ( 3 )
             */
            THREE(3),
            /**
             * @Fields FOUR : ( 4 )
             */
            FOUR(4),
            /**
             * @Fields FIVE : ( 5 )
             */
            FIVE(5),
            /**
             * @Fields FIVE : ( 6 )
             */
            SIX(6),
            /**
             * @Fields FIVE : ( 7 )
             */
            Seven(7),
            /**
             * @Fields FIVE : ( 8 )
             */
            Eight(8),
            /**
             * @Fields FIVE : ( 9 )
             */
            Nine(9),
            /**
             * @Fields FIVE : ( 10 )
             */
            Ten(10);

            private final Integer key;

            private ConstantNumber(Integer key) {
                this.key = key;
            }

            /**
             * @Title: getKey
             * @Description: ()
             */
            public Integer getKey() {
                return key;
            }
        }


        /**
         * @author qierkang xyqierkang@163.com
         * @Title: ConstantInterface.java
         * @Package com.fintech.util.enumerator
         * @date 2018年6月29日 下午11:45:00
         * @Description: TODO[ 用一句话描述该文件做什么 ]
         */
        enum CONTENT_TYPE {
            /**
             * @Fields CONTENT_TYPE_TEXTHTML : TODO[ 用一句话描述这个变量表示什么 ]
             */
            CONTENT_TYPE_TEXTHTML("text/html"),
            /**
             * @Fields CONTENT_TYPE_APPLICATION_X_WWW_FORM_URLENCODED : TODO[
             * 最常见的 POST 提交数据的方式了。浏览器的原生 form 表单，如果不设置 enctype 属性，
             * 那么最终就会以 application/x-www-form-urlencoded方式提交数据。
             * 传递的key/val会经过URL转码，所以如果传递的参数存在中文或者特殊字符需要注意。 ]
             * //例子
             * //b=曹,a=1
             * POST  HTTP/1.1(CRLF)
             * Host: www.example.com(CRLF)
             * Content-Type: application/x-www-form-urlencoded(CRLF)
             * Cache-Control: no-cache(CRLF)
             * (CRLF)
             * b=%E6%9B%B9&a=1(CRLF)
             * //这里b参数的值"曹"因为URL转码变成其他的字符串了
             */
            CONTENT_TYPE_APPLICATION_X_WWW_FORM_URLENCODED("application/x-www-form-urlencoded"),
            /**
             * @Fields CONTENT_TYPE_APPLICATION_JSON : TODO[ 用一句话描述这个变量表示什么 ]
             */
            CONTENT_TYPE_APPLICATION_JSON("application/json;charset=UTF-8"),
            /**
             * @Fields CONTENT_TYPE_MULTIPART_FORM_DATA : TODO[
             * 使用表单上传文件时，必须让 form 的 enctyped 等于这个值。
             * 并且Http协议会使用boundary来分割上传的参数
             * ]
             */
            CONTENT_TYPE_MULTIPART_FORM_DATA("multipart/form-data");
            private final String value;

            private CONTENT_TYPE(String value) {
                this.value = value;
            }

            public String getValue() {
                return value;
            }

            @Override
            public String toString() {
                return "[" + this.value + "]";
            }
        }

        /**
         * @author qierkang xyqierkang@163.com
         * @Title: ConstantInterface.java
         * @Package com.fintech.util.enumerator
         * @date 2018年6月12日 上午1:26:50
         * @Description: TODO[ 通用返回值 ]
         */
        enum ObjectNullValidate {
            OBJECT_NAME_99910(99910, "该属性不能为空"),
            OBJECT_MESSAGE_99911(99911, "属性传入错误，请检查属性是否正确"),
            OBJECT_REDIS_KEY_99912(99912, "非法请求，Token Key is null"),
            OBJECT_REDIS_KEY_99913(99913, "帐号或密码错误！"),
            OBJECT_REDIS_KEY_99914(99914, "查无此用户！");
            private Integer key;
            private String value;

            /**
             * @return the key
             */
            public Integer getKey() {
                return key;
            }

            /**
             * @param key 要设置的 key
             */
            public void setKey(Integer key) {
                this.key = key;
            }

            /**
             * @return the value
             */
            public String getValue() {
                return value;
            }

            /**
             * @param value 要设置的 value
             */
            public void setValue(String value) {
                this.value = value;
            }

            /**
             * @param @param key
             * @param @param value    设定文件
             *
             * @throws
             * @Title: ConstantInterface.java
             * @Description: TODO[ 这里用一句话描述这个方法的作用 ]
             */
            private ObjectNullValidate(Integer key, String value) {
                this.key = key;
                this.value = value;
            }

            @Override
            public String toString() {
                return "[" + this.key + "]" + this.value;
            }
        }
    }

    interface DruidDataConfig {
        /**
         * @author qierkang
         * @ClassName: ConstantNumber
         * @date 2016年5月19日
         * @Description: (数据库信息 多数据源需要指定Map如 mapper / fintech / * .xml mapper / xxxx / * .xml)
         * 精确到 mapper 和他数据源隔离
         */
        enum DRUIDDATA_CONFIG {
            PROCEDURE_MAPPER("classpath*:mapper/*/*.xml"),
            FINTECH_MAPPER("classpath*:mapper/*.xml");
            private String value;

            public String getValue() {
                return value;
            }

            private DRUIDDATA_CONFIG(String value) {
                this.value = value;
            }

        }
    }

    enum LoginValidate {
        LOGIN_200300(200300, "登录失效，请重新登录"),
        LOGIN_200301(200301, "验证码错误或失效！"),
        LOGIN_200302(200302, "该订单已被后台取消"),
        LOGIN_200303(200303, "该用户已禁用，请联系管理员");
        private Integer key;
        private String value;

        public Integer getKey() {
            return key;
        }

        public void setKey(Integer key) {
            this.key = key;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        private LoginValidate(Integer key, String value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "[" + this.key + "]" + this.value;
        }
    }

    enum RoleValidate {
        LOGIN_200400(200400, "该角色名已经重复"),
        LOGIN_200401(200401, "该角色已经关联用户请先解除用户");
        private Integer key;
        private String value;

        public Integer getKey() {
            return key;
        }

        public void setKey(Integer key) {
            this.key = key;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        private RoleValidate(Integer key, String value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "[" + this.key + "]" + this.value;
        }
    }

}
