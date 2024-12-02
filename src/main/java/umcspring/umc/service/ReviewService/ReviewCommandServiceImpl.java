package umcspring.umc.service.ReviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umcspring.umc.apiPayload.code.status.ErrorStatus;
import umcspring.umc.apiPayload.exception.handler.TempHandler;
import umcspring.umc.converter.ReviewConverter;
import umcspring.umc.domain.Member;
import umcspring.umc.domain.Review;
import umcspring.umc.domain.Store;
import umcspring.umc.repository.MemberRepository;
import umcspring.umc.repository.ReviewRepository;
import umcspring.umc.repository.StoreRepository.StoreRepository;
import umcspring.umc.web.dto.ReviewRequestDTO;

@Service
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService{

    private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepository;
    private final StoreRepository storeRepository;

    @Override
    @Transactional
    public Review createReview(ReviewRequestDTO.CreateDTO request) {
        Review newReview = ReviewConverter.toReview(request);

        //member 유효성 검사 후 저장
        Long memberId = request.getMemberId();
        Member member = memberRepository.findById(memberId)
                        .orElseThrow(() -> new TempHandler(ErrorStatus.MEMBER_NOT_FOUND));
        newReview.setMember(member);
        //store 유효성 검사 후 저장
        Long storeId = request.getStoreId();
        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new TempHandler(ErrorStatus.STORE_NOT_FOUND));
        //reviewImages 저장

        return reviewRepository.save(newReview);
    }
}
