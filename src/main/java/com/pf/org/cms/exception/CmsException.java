package com.pf.org.cms.exception;

/**
 * @Auther: pf
 * @Date: 2018/3/30 15:53
 * @Description:
 */
public class CmsException extends RuntimeException {
    public CmsException(String msg)
    {
        super(msg);
    }

    public CmsException(Throwable t) {
        super(t);
    }

    public CmsException(String msg, Throwable t) {
        super(msg, t);
    }
}
