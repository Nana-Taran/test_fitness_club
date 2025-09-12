package app.repository;

import app.damain.Member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberRepository {

    private final Map<Long, Member> database = new HashMap<>();
    private long maxId;

    public Member save (Member member) {
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
    public void deleteById(Long id) {
        database.remove(id);

    }


}
