package app.repository;

import app.damain.Member;
import app.damain.Member;   // важно. domain, не damain

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;import java.util.ArrayList;



public class MemberRepository {

    private final Map<Long, Member> database = new HashMap<>();
    private long maxId;

    public Member save(Member member) {
        member.setId(++maxId);
        database.put(maxId, member);
        return member;
    }

    public List<Member> findAll() {
        return new ArrayList<>(database.values());
    }

    public Member findById(Long id) {
        return database.get(id);
    }

    public Member findByName(String name) {
        if (name == null) return null;
        return database.values().stream()
                .filter(m -> name.equals(m.getName()))
                .findFirst()
                .orElse(null);
    }

    public void deleteById(Long id) {
        database.remove(id);
    }
}

