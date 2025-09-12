package app.service;

import app.damain.Member;
import app.exceptions.MemberNotFoundException;
import app.exceptions.MemberRestotrException;
import app.exceptions.MemberSaveException;
import app.repository.MemberRepository;

import java.util.List;

public class MemberService {
    private final MemberRepository repository = new MemberRepository();
    private static MemberService instance;

    private MemberService() {


    }

    public static MemberService getInstance() {
        if (instance == null) {
            instance = new MemberService();
        }
        return instance;
    }

    public Member save(Member member) {
        if (member == null) {
            throw new MemberSaveException("Пользователь не может быть null");
        }
        String name = member.getName();
        if (name == null || name.trim().isEmpty()){
            throw new MemberSaveException("Имя пользователя не может быть пустым");
        }

        member.setActive(true);
        return repository.save(member);

    }
    public List<Member> getAllActiveMembers() {
        return repository.findAll()
                .stream()
                .filter(Member::isActive)
                .toList();



    }

    public Member getActiveMemberById(Long id) {
        Member member = repository.findById(id);

        if (member == null || !member.isActive()) {
            throw new MemberNotFoundException(id);
        }
        return member;
    }

    public void deleteById(Long id) {
        Member member =getActiveMemberById(id);
        member.setActive(false);

    }
    public void deleteByName(String name) {
        getAllActiveMembers()
                .stream()
                .filter(x -> x.getName().equals(name))
                .forEach(x -> x.setActive(false));
    }
    public void restoreById(Long id) {
        Member member = repository.findById(id);

        if(member == null){
            throw new MemberNotFoundException(id);
        }
        member.setActive(true);
    }
    public void restoreByName(String name) {
        if (name == null || !name.trim().isEmpty()){
            throw new MemberRestotrException("Введите корректное имя");

        }
        Member member = repository.findByName(name);
        member.setActive(true);
    }


}