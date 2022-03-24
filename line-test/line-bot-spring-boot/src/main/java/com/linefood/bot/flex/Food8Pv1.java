package com.linefood.bot.flex;

import com.linecorp.bot.model.action.URIAction;
import com.linecorp.bot.model.message.FlexMessage;
import com.linecorp.bot.model.message.flex.component.*;
import com.linecorp.bot.model.message.flex.component.Button.ButtonHeight;
import com.linecorp.bot.model.message.flex.component.Image.ImageAspectMode;
import com.linecorp.bot.model.message.flex.component.Image.ImageAspectRatio;
import com.linecorp.bot.model.message.flex.container.Bubble;
import com.linecorp.bot.model.message.flex.unit.FlexFontSize;
import com.linecorp.bot.model.message.flex.unit.FlexLayout;
import com.linecorp.bot.model.message.flex.unit.FlexMarginSize;

import java.util.function.Supplier;

import static java.util.Arrays.asList;

public class Food8Pv1 implements Supplier<FlexMessage> {
    @Override
    public FlexMessage get() {
        final Image heroBlock = createHeroBlock();
        final Box bodyBlock = createBodyBlock();
        final Box footerBlock = createFooterBlock();

        final Bubble bubbleContainer = Bubble.builder()
                .hero(heroBlock)
                .body(bodyBlock)
                .footer(footerBlock)
                .build();
        return new FlexMessage("Restaurant", bubbleContainer);
    }

    private Image createHeroBlock() {
        return Image.builder()
                .url("https://ed.edtfiles-media.com/ud/gal/dcp/26/76147/Mu_Tum_Lamyai.jpg")
                .size(Image.ImageSize.FULL_WIDTH)
                .aspectRatio(ImageAspectRatio.R20TO13)
                .aspectMode(ImageAspectMode.Cover)
                .action(new URIAction("label", "http://example.com"))
                .build();
    }

    private Box createBodyBlock() {
        final Text title = Text.builder()
                .text("วิธีหมูตุ๋นเนื้อลำไย ")
                .weight(Text.TextWeight.BOLD)
                .size(FlexFontSize.XL)
                .build();
        
        final Box info = createInfoBox();

        return Box.builder()
                .layout(FlexLayout.VERTICAL)
                .contents(asList(title,info))
                .build();
    }

    private Box createInfoBox() {
        final Box place = Box.builder()
                .layout(FlexLayout.BASELINE)
                .spacing(FlexMarginSize.SM)
                .contents(asList(
                        Text.builder()
                            .text("วัตถุดิบ\n 1.เนื้อขัวตับหมู1 กิโล\n  2.เนื้อลำไยอบแห้ง200 กรัม\n  3.น้ำตาลทรายแดง1 ทัพพี\n 4.เกลือ1 ชต.5.น้ำเปล่า2ลิตร\n  6.เครื่องเทศ สำหรับเนื้อตุ๋น สำเร็จรูป1 ห่อ 1\n วิธีทำ\n 1.ล้างทำความสะอาดเนื้อหมู เติมน้ำแล้วตั้งไฟ กลาง \n  2.เติมเครื่องเทศ ลงไป ตามด้วย เครื่องปรุงรส และ เนื้อลำไยแห้ง หรือลำไยต้ม(เคล็ดลับ: เนื้อลำไยใส่แบบ แห้งๆเลยจะ หอมมาก แต่โยเย มีต้มไว้แล้วเลยใส่แบบต้ม) \n  3.ปิดฝาหม้อเคี่ยว2 ชม. จนเนื้อสุดเปื่อยนุ่มดี ก็ทานได้เลยค่ะ จะเอาไปทำ ข้าวต้มก๋วยเตี๋ยว เกาเหลาได้หมดเลย ง่ายจริง")
                            .wrap(true)
                            .color("#666666")
                            .flex(5)
                            .build()
                )).build();
        
        return Box.builder()
                .layout(FlexLayout.VERTICAL)
                .margin(FlexMarginSize.LG)
                .spacing(FlexMarginSize.SM)
                .contents(asList(place))
                .build();
    }


    private Box createFooterBlock() {
        final Spacer spacer = Spacer.builder().size(FlexMarginSize.SM).build();
        final Separator separator = Separator.builder().build();
        final Button websiteAction = Button.builder()
                .style(Button.ButtonStyle.LINK)
                .height(ButtonHeight.SMALL)
                .action(new URIAction("WEBSITE", "https://guide.michelin.com/th/th/article/features/10-northern-thai-dishes-you-should-know"))
                .build();

        return Box.builder()
                .layout(FlexLayout.VERTICAL)
                .spacing(FlexMarginSize.SM)
                .contents(asList(spacer, separator, websiteAction))
                .build();

    }
}

