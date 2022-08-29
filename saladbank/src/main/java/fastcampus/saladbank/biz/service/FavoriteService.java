package fastcampus.saladbank.biz.service;

import fastcampus.saladbank.biz.domain.*;
import fastcampus.saladbank.biz.repository.FavoriteItemRepository;
import fastcampus.saladbank.biz.repository.FavoriteRepository;
import fastcampus.saladbank.biz.repository.MemberRepository;
import fastcampus.saladbank.web.dto.MemberForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Entity;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly=true)
public class FavoriteService {

    private final FavoriteRepository favoriteRepository;
    private final FavoriteItemRepository favoriteItemRepository;
    private final MemberRepository memberRepository;

    //관심상품 삭제
    @Transactional
    public void deleteFavorite(long id) {
        Optional<Favorite> favorite = favoriteRepository.findById(id);
        favoriteItemRepository.deleteAllByFavorite(favorite);
    }

    //관심상품 추가
    @Transactional
    public void insertFavorite() {
    }
    //관심상품 조회
    public List<FavoriteItem> getFavorites(MemberForm reqMember) {
        String username = reqMember.getUsername();
        Optional<Member> member = memberRepository.findByUsername(username);
        Favorite favorite = favoriteRepository.findByMember(member);
        List<FavoriteItem> favoriteItem = favoriteItemRepository.findAllByFavorite(favorite);
        return favoriteItem;
    }

}
