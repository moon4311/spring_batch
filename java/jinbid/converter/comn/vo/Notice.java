package jinbid.converter.comn.vo;

import lombok.Data;
import org.apache.commons.lang3.time.DateFormatUtils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * 공고
 *
 * @author Kim Jae Moon
 * @since 2017. 4. 06.
 */
@Data
public class Notice extends Basic{

    /** ID */
    private Long id;

    /** 공고번호 */
    private String notiNo;

    /** 공고순번 */
    private String notiSeq;

    /** 공고명 */
    private String notiNm;

    /** 공사번호 */
    private String cnstNo;

    /**
     * 공종코드(0: 시설, 1: 용역, 2: 물품)
     * ※ 면허에 따라 판단함  - 면허구분코드가 모두 '용역'이면 다른 공종코드라도 '용역'으로 설정
     */
    private String notiKindCd;

    /** 공종코드명 */
    private String notiKindCdNm;

    /** 수집방식코드 0: 수집기 + 대기 1: 수집기 + 완료 2: 수작업 + 완료 3: 수집기 대기 + 수작업 완료 4: 수집기 완료 + 수작업 수정 5: 수작업 완료 + 수작업 수집 */
    private String colctMethCd = "2";

    /** 공고진행상태코드(0: 완료, 1: 대기, 2: 삭제, 9: 폐기) */
    private String notiProgStatCd;

    /** 공고진행상태코드명 */
    private String notiProgStatCdNm;

    /** 공고구분코드(0: 일반, 1: 정정, 2: 취소) */
    private String notiDstnctCd = "0";

    /** 대표기관코드 */
    private String rpsntOrgnzCd;

    /** 대표기관코드명 */
    private String rpsntOrgnzCdNm;

    /** 대표기관줄임명 */
    private String rpsntOrgnzCdSoNm;

    /** 발주처코드 */
    private String orderOffiCd;

    /** 발주처코드명 */
    private String orderOffiCdNm;

    /** 실수요기관코드 */
    private String actulDnttCd;

    /** 실수요기관코드명 */
    private String actulDnttCdNm;

    /** 공고개시일시 */
    private String notiStrtDt = DateFormatUtils.format(Calendar.getInstance(), "yyyy-MM-dd HH:mm:ss");

    /** 투찰개시일시 */
    private String bddprStrtDt;

    /** 등록마감일시 */
    private String regstFinDt;

    /** 투찰마감일시 */
    private String bddprFinDt;

    /** 투찰참여업체수 */
    private Long bddprPrtcCmpCnt = 0L;

    /** 개찰일시 */
    private String opbdDt;

    /** 개찰예정가격 */
    private Long opbdPrargPrice = 0L;

    /** 개찰상태코드(0: 개찰전, 1: 미개찰, 2: 개찰, 3: 유찰, 4:재입찰, 5:최종낙찰) */
    private String opbdStatCd = "0";

    /** 발주처개찰일시 */
    private String orderOffiOpbdDt;
    
    /** 현장설명일시 */
    private String siteDescDt;

    /** 현장설명장소 */
    private String siteDescPlac;

    /** 현장설명필수여부 */
    private String siteDescMandaYn = "N";

    /** 추정금액 */
    private String presmAmt;

    /** 기초금액 */
    private String baseAmt;

    /** 계약방법ID */
    private Long cntrMthdId;

    /** 계약방법명 */
    private String cntrMthdNm;

    /** 정렬순서 */
    private int sortOrdr;

    /** 하한율 */
    private String dwnlmtRt;

    /** 최소사정율 */
    private String minAsRt;

    /** 최고사정율 */
    private String maxAsRt;

    /** 산출기초금액 */
    private String prdcBaseAmt = "0";

    /** 적격심사기준ID */
    private Long cfmtUndwrtStId;

    /** 적격심사기준 */
    private String cfmtUndwrtSt;

    /** 재입찰번호 */
    private String rebidNo;

    /** 실적심사신청마감일시 */
    private String arstudwrtApplyFinDt;

    /** 담당자명 */
    private String chrgrNm;

    /** 담당자부서명 */
    private String chrgrDeptNm;

    /** 담당자전화번호 */
    private String chrgrTelno;

    /** 담당자이메일 */
    private String chrgrEmail;

    /** 공사지역위치 */
    private String cnstAreaLocat;

    /** 공사기간 */
    private String cnstPerd;

    /** 정정사유 */
    private String corctRsn;

    /** 특이사항 */
    private String rmrk;

    /** 통화메모 */
    private String talkMemo;

    /** 소상공인여부 */
    private String schtwrYn = "N";

    /** 여성장애인기업여부 */
    private String femaleHndcCoYn = "N";

    /** 특허신기술여부 */
    private String patentNtcnqYn = "N";

    /** 보증금납부여부 */
    private String guramtPymYn = "N";

    /** 내역입찰여부 */
    private String spcfctBidYn = "N";

    /** 최저가입찰여부 */
    private String mnprBidYn = "N";

    /** 실적무시여부 */
    private String acrsltIgnorYn = "N";

    /** 수의공고여부 */
    private String vltrnNotiYn = "N";

    /** 단가공고여부 */
    private String univalNotiYn = "N";

    /** 시담공고여부 */
    private String prvstlNotiYn = "N";

    /** 민간공고여부 */
    private String prvtNotiYn = "N";

    /** 긴급공고여부 */
    private String emgNotiYn = "N";

    /** 재공고여부 */
    private String renotiYn = "N";

    /** 연기공고여부 */
    private String pstponeNotiYn = "N";

    /** 전자입찰여부(Y: 전자, N: 방문) */
    private String electBidYn = "N";

    /** 공동수급협정서마감일시 */
    private String spdmagmtFinDt;

    /** 주계약자도급비율 */
    private Long mnrcrOutsrcRate = 0L;

    /** 공동이행가능여부 */
    private String unionTrsfPsblYn = "N";

    /** 분담이행가능여부 */
    private String shrTrsfPsblYn  = "N";

    /** 지역의무여부 */
    private String areaDutyYn = "N";

    /** 단독가능여부 */
    private String singlPsblYn = "N";

    /** 신규공고여부(최신여부) */
    private String newestNotiYn = "Y";

    /** 수집페이지구분코드
     * 0: 국방부 > 국내조달 > 경쟁입찰
     * 1: 국방부 > 국내조달 > 공개수의협상
     * 2: 국방부 > 시설공사 > 경쟁입찰
     * 3: 국방부 > 시설공사 > 공개수의협상
     */
    private String colctPageDstnctCd;

    /** 최초입력일시 */
    private String firstInputDt;

    /** 최초입력자 */
    private String firstInptps;

    /** 최종수정일시 */
    private String lastUpdtDt;

    /** 최종수정자 */
    private String lastAmndr;

    /** 사용여부 */
    private String useYn = "Y";
    
    /** 검증ID ( 구DB keyBaseTable ) */
    private long prfId;
    
    /** 검증일자 ( 구DB 입력일 ) */
    private String prfDt;  
    
    /** 오늘날짜 검증 */
    private String toDayDt;  

    /** 공고면허 목록 */
    private List<NoticeLicns> noticeLicnsList = new ArrayList<>();

    /** 공고지역 목록 */
    private List<NoticeArea> noticeAreaList = new ArrayList<>();

    /** 공고첨부파일 목록 */
    private List<NoticeAtchmnfl> noticeAtchmnflList = new ArrayList<>();

    /** 공고투찰참여업체 목록 */
    private List<NoticeBddprPrtcCmp> noticeBddprPrtcCmpList = new ArrayList<>();

    /** 공고낙찰예정업체 목록 */
    private List<NoticeSbidPrargCmp> noticeSbidPrargCmpList = new ArrayList<>();

    /** 공고복수예가 목록 */
    private List<NoticeCompnoPrdprc> noticeCompnoPrdprcList = new ArrayList<>();

    /** 공고이력 목록 */
//    private List<NoticeHist> noticeHistList = new ArrayList<>();
    ;
    
    public Notice noticeOpenBid(Notice b) {
		this.setOpbdPrargPrice(b.getOpbdPrargPrice());
		this.setBddprPrtcCmpCnt(b.getBddprPrtcCmpCnt());
		this.setOpbdStatCd(b.getOpbdStatCd());
		this.setDwnlmtRt(b.getDwnlmtRt());
		
		return this;
	}
    
	public Notice noticeResult(Notice tmp){
		this.setBddprPrtcCmpCnt(tmp.getBddprPrtcCmpCnt());
		this.setOpbdStatCd(tmp.getOpbdStatCd());
		this.setOrderOffiOpbdDt(tmp.getOrderOffiOpbdDt());
		return this;
	}
    
	public Notice noticeAppend(Notice tmp){
		this.setCnstAreaLocat(tmp.getCnstAreaLocat());
		this.setCnstPerd(tmp.getCnstPerd());
		this.setCorctRsn(tmp.getCorctRsn());
		this.setRmrk(tmp.getRmrk());
		this.setSchtwrYn(tmp.getSchtwrYn());
		this.setFemaleHndcCoYn(tmp.getFemaleHndcCoYn());
		this.setChrgrDeptNm(tmp.getChrgrDeptNm());
		this.setChrgrTelno(tmp.getChrgrTelno());
		this.setChrgrEmail(tmp.getChrgrEmail());
		this.setUnionTrsfPsblYn(tmp.getUnionTrsfPsblYn());
		this.setShrTrsfPsblYn(tmp.getShrTrsfPsblYn());
		this.setAreaDutyYn(tmp.getAreaDutyYn());
		this.setSinglPsblYn(tmp.getSinglPsblYn());
		return this;
	}
}
