package com.deku.common.feign;

import com.deku.common.base.enums.CommonEnum;
import com.deku.common.base.model.support.BaseResponse;
import com.deku.common.base.utils.JsonUtils;

/**
 * 通用的熔断方法
 *
 * @author: deku
 * @date: 2018/8/22
 */
public class Fallback {

    public static String badGateway() {
        return JsonUtils.objectToJson(BaseResponse.builder().message(CommonEnum.BAD_GATEWAY.getErrMsg()).build());
    }
}
