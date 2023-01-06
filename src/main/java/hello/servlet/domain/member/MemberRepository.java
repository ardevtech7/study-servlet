package hello.servlet.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 동시성 문제가 고려되어 있지 않음, 실무에서는 ConcurrentHashMap, AtomicLong 사용 고려
 */
public class MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    /*
        회원 저장소는 싱글톤 패턴을 적용
        - 스프링을 사용하면 스프링 빈으로 등록하면 되지만, 지금은 최대한 스프링 없이 순수 서블릿으로만 구현하는 것이 목적
     */
    private static final MemberRepository instance = new MemberRepository();

    // 조회는 무조건 getInstance()로 하도록 설정
    public static MemberRepository getInstance() {
        return instance;
    }

    // Singleton 으로 만들 때는 객체를 단 하나만 생성해서 공유해야 하므로 생성자를 private 접근자를 붙여서 아무나 생성하지 못하도록 막는다.
    private MemberRepository() {
    }

    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);

        return member;
    }

    public Member findById(Long id) {
        return store.get(id);
    }

    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }

}
