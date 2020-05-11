package com.akoca.mvc.controller.test;

import com.akoca.mvc.domain.test.Visitor;
import com.akoca.mvc.domain.test.VisitorCount;
import com.akoca.mvc.domain.test.VisitorData;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class VisitorService {

    public VisitorCount updateCount(VisitorCount visitorCount) {
        visitorCount.setCount(visitorCount.getCount() + 1);

        return visitorCount;
    }

    public void registerVisitor(VisitorData sessionData , VisitorData incomingVisitor) {
        List<Visitor> visitors = sessionData.getVisitorList();

        sessionData.setCurrentVisitorName(incomingVisitor.getCurrentVisitorName());
        sessionData.setCurrentVisitorEmail((incomingVisitor.getCurrentVisitorEmail()));

        visitors.add(new Visitor(incomingVisitor.getCurrentVisitorName() , incomingVisitor.getCurrentVisitorEmail()));
    }

    public long computeDuration(LocalDateTime sessionStartTime) {
        Duration sessionDuration = Duration.between(sessionStartTime , LocalDateTime.now());

        return sessionDuration.getSeconds();
    }

    public String describeCurrentTime(LocalDateTime currentTime) {
        return currentTime.toString();
    }

    public String describeCurrentDuration(long currentDuration) {
        return "Current duration is: " + currentDuration + " seconds";
    }
}
