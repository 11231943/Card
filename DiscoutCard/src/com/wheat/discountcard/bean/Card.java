package com.wheat.discountcard.bean;


/**
 * Card entity. @author MyEclipse Persistence Tools
 */

public class Card implements java.io.Serializable
{

    // Fields

    private Long id;

    private String cardSummary;

    private String cardName;

    private String cardAddress;

    private String cardSpecialTipsContent;

    private String cardZone;

    private String cardSaleCode;

    private String cardClassName;

    private Integer cardClass;

    private Integer cardDownLoadCount;

    private Long cardValidityTime;

    private Long cardCreateTime;

    private String distanceX;

    private String distanceY;

    private Long bsId;

    private Integer cardType;
    
    private Long userId;
    
    private String userName;
    
    private int juli;
    
    
    // Constructors

    public int getJuli()
    {
        return juli;
    }

    public void setJuli(int juli)
    {
        this.juli = juli;
    }

    public Long getUserId()
    {
        return userId;
    }

    public void setUserId(Long userId)
    {
        this.userId = userId;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    /** default constructor */
    public Card()
    {
    }

    /** full constructor */
    public Card(String cardSummary, String cardName, String cardAddress,
            String cardSpecialTipsContent, String cardZone,
            String cardSaleCode, String cardClassName, Integer cardClass,
            Integer cardDownLoadCount, Long cardValidityTime,
            Long cardCreateTime, String distanceX, String distanceY, Long bsId,
            Integer cardType)
    {
        this.cardSummary = cardSummary;
        this.cardName = cardName;
        this.cardAddress = cardAddress;
        this.cardSpecialTipsContent = cardSpecialTipsContent;
        this.cardZone = cardZone;
        this.cardSaleCode = cardSaleCode;
        this.cardClassName = cardClassName;
        this.cardClass = cardClass;
        this.cardDownLoadCount = cardDownLoadCount;
        this.cardValidityTime = cardValidityTime;
        this.cardCreateTime = cardCreateTime;
        this.distanceX = distanceX;
        this.distanceY = distanceY;
        this.bsId = bsId;
        this.cardType = cardType;
    }

    // Property accessors

    public Long getId()
    {
        return this.id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getCardSummary()
    {
        return this.cardSummary;
    }

    public void setCardSummary(String cardSummary)
    {
        this.cardSummary = cardSummary;
    }

    public String getCardName()
    {
        return this.cardName;
    }

    public void setCardName(String cardName)
    {
        this.cardName = cardName;
    }

    public String getCardAddress()
    {
        return this.cardAddress;
    }

    public void setCardAddress(String cardAddress)
    {
        this.cardAddress = cardAddress;
    }

    public String getCardSpecialTipsContent()
    {
        return this.cardSpecialTipsContent;
    }

    public void setCardSpecialTipsContent(String cardSpecialTipsContent)
    {
        this.cardSpecialTipsContent = cardSpecialTipsContent;
    }

    public String getCardZone()
    {
        return this.cardZone;
    }

    public void setCardZone(String cardZone)
    {
        this.cardZone = cardZone;
    }

    public String getCardSaleCode()
    {
        return this.cardSaleCode;
    }

    public void setCardSaleCode(String cardSaleCode)
    {
        this.cardSaleCode = cardSaleCode;
    }

    public String getCardClassName()
    {
        return this.cardClassName;
    }

    public void setCardClassName(String cardClassName)
    {
        this.cardClassName = cardClassName;
    }

    public Integer getCardClass()
    {
        return this.cardClass;
    }

    public void setCardClass(Integer cardClass)
    {
        this.cardClass = cardClass;
    }

    public Integer getCardDownLoadCount()
    {
        return this.cardDownLoadCount;
    }

    public void setCardDownLoadCount(Integer cardDownLoadCount)
    {
        this.cardDownLoadCount = cardDownLoadCount;
    }

    public Long getCardValidityTime()
    {
        return this.cardValidityTime;
    }

    public void setCardValidityTime(Long cardValidityTime)
    {
        this.cardValidityTime = cardValidityTime;
    }

    public Long getCardCreateTime()
    {
        return this.cardCreateTime;
    }

    public void setCardCreateTime(Long cardCreateTime)
    {
        this.cardCreateTime = cardCreateTime;
    }

    public String getDistanceX()
    {
        return this.distanceX;
    }

    public void setDistanceX(String distanceX)
    {
        this.distanceX = distanceX;
    }

    public String getDistanceY()
    {
        return this.distanceY;
    }

    public void setDistanceY(String distanceY)
    {
        this.distanceY = distanceY;
    }

    public Long getBsId()
    {
        return this.bsId;
    }

    public void setBsId(Long bsId)
    {
        this.bsId = bsId;
    }

    public Integer getCardType()
    {
        return this.cardType;
    }

    public void setCardType(Integer cardType)
    {
        this.cardType = cardType;
    }

}