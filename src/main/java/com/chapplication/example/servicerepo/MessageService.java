package com.chapplication.example.servicerepo;
import com.chapplication.example.objects.MessageObject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageService extends JpaRepository<MessageObject, Long> {
}
