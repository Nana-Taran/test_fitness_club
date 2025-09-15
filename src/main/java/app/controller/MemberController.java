package app.controller;

import app.damain.Member;
import app.service.MemberService;

import java.util.List;

public class MemberController {

    private final MemberService service = MemberService.getInstance();

    // Сохранить клиента
    public Member save(String name) {
        Member member = new Member();
        member.setName(name);
        return service.save(member);
    }

    // Получить всех активных клиентов
    public List<Member> getAll() {
        return service.getAllActiveMembers();
    }

    // Получить активного клиента по ID
    public Member getById(Long id) {
        return service.getActiveMemberById(id);
    }

    // Удалить клиента по ID
    public void deleteById(Long id) {
        service.deleteById(id);
    }

    // Удалить клиента по имени
    public void deleteByName(String name) {
        service.deleteByName(name);
    }

    // Восстановить клиента по ID
    public void restoreById(Long id) {
        service.restoreById(id);
    }

    // Восстановить клиента по имени
    public void restoreByName(String name) {
        service.restoreByName(name);
    }
}

