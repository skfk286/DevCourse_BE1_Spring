package com.devcourse.ycjung.day_0812.aop.ver05_aop_proxy;

// 실제 Person 은 Boy 또는 Girl 이지만 Proxy 가 Person 인 척 대리인 역할을 수행한다.
public class PersonProxy implements Person {

    private IBefore before;
    private IAfterReturning afterReturn;
    private IAfterThrowing afterThorow;
    private IAfter after;
    private Person target; // 핵심 관심사항 구현체, Boy 또는 Girl 과 같은..

    public void setTarget(Person target) {
        this.target = target;
    }

    public void setBefore(IBefore before) {
        this.before = before;
    }

    public void setAfterReturn(IAfterReturning afterReturn) {
        this.afterReturn = afterReturn;
    }

    public void setAfterThorow(IAfterThrowing afterThorow) {
        this.afterThorow = afterThorow;
    }

    public void setAfter(IAfter after) {
        this.after = after;
    }

    @Override
    public void makeFood() throws Exception {
        if (before != null)
            before.doBefore(); // 오늘 월요일인데 많이 피곤하시죠?

        try {
            target.makeFood(); // aop 어때요?
            if(afterReturn != null)
                afterReturn.doAfterReturn(); // 오늘 저녁에는 어떤 학습 계획이 있으신가요?
        } catch (Exception e) {
            if(afterThorow != null)
                afterThorow.doAfterThrow();
        } finally {
            if(after != null)
                after.doAfter();
        }
    }
}
