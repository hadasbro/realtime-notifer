package org.bitbucket.slawekhaa.realtimenotifer.domain;

import java.time.OffsetDateTime;

@SuppressWarnings({"unused","WeakerAccess","WeakAccess"})
public class SingleMessage {
    public String message;
    public Long toUserId;
    public String toUsessToken;
    public OffsetDateTime time;

    public SingleMessage() {
    }

    public SingleMessage(String message, Long toUserId, String toUsessToken, OffsetDateTime time) {
        this.message = message;
        this.toUserId = toUserId;
        this.toUsessToken = toUsessToken;
        this.time = time;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public OffsetDateTime getTime() {
        return time;
    }

    public void setTime(OffsetDateTime time) {
        this.time = time;
    }

    public void setToUserId(Long toUserId) {
        this.toUserId = toUserId;
    }

    public String getToUsessToken() {
        return toUsessToken;
    }

    public void setToUsessToken(String toUsessToken) {
        this.toUsessToken = toUsessToken;
    }

    @Override
    public String toString() {
        return "SingleMessage{" +
                "message='" + message + '\'' +
                ", toUserId=" + toUserId +
                ", toUsessToken='" + toUsessToken + '\'' +
                ", time=" + time +
                '}';
    }

    public Long getToUserId() {
        return toUserId;
    }
}
