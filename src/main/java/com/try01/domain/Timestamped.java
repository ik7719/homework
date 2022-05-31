package com.try01.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass // 추상클래스에 사용할 수 있으며 엔티티가 될 수 없고 상속을 통해서 사용해야 한다.
@EntityListeners(AuditingEntityListener.class) // 생성/변경 시간을 자동으로 업데이트합니다.
public abstract class Timestamped {

    @CreatedDate //JPA 저장소가 save()할 때 자동으로 생성시간을 만든다.
    private LocalDateTime createdAt; // 시간을 나타내는 자료형


    @LastModifiedDate // JPA 저장소가 수정할 때 자동으로 생성시간을 만든다.
    private LocalDateTime modifiedAt;
}
