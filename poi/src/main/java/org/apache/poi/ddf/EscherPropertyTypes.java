/* ====================================================================
 Licensed to the Apache Software Foundation (ASF) under one or more
 contributor license agreements.  See the NOTICE file distributed with
 this work for additional information regarding copyright ownership.
 The ASF licenses this file to You under the Apache License, Version 2.0
 (the "License")), you may not use this file except in compliance with
 the License.  You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 ==================================================================== */

package org.apache.poi.ddf;

import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Provides a list of all known escher properties including the description and type.
 */
@SuppressWarnings({"java:S115"})
public enum EscherPropertyTypes {
    TRANSFORM__ROTATION(0x0004, "transform.rotation"),
    PROTECTION__LOCKROTATION(0x0077, "protection.lockrotation"),
    PROTECTION__LOCKASPECTRATIO(0x0078, "protection.lockaspectratio"),
    PROTECTION__LOCKPOSITION(0x0079, "protection.lockposition"),
    PROTECTION__LOCKAGAINSTSELECT(0x007a, "protection.lockagainstselect"),
    PROTECTION__LOCKCROPPING(0x007b, "protection.lockcropping"),
    PROTECTION__LOCKVERTICES(0x007c, "protection.lockvertices"),
    PROTECTION__LOCKTEXT(0x007d, "protection.locktext"),
    PROTECTION__LOCKADJUSTHANDLES(0x007e, "protection.lockadjusthandles"),
    PROTECTION__LOCKAGAINSTGROUPING(0x007f, "protection.lockagainstgrouping", EscherPropertyTypesHolder.BOOLEAN),
    TEXT__TEXTID(0x0080, "text.textid"),
    TEXT__TEXTLEFT(0x0081, "text.textleft"),
    TEXT__TEXTTOP(0x0082, "text.texttop"),
    TEXT__TEXTRIGHT(0x0083, "text.textright"),
    TEXT__TEXTBOTTOM(0x0084, "text.textbottom"),
    TEXT__WRAPTEXT(0x0085, "text.wraptext"),
    TEXT__SCALETEXT(0x0086, "text.scaletext"),
    TEXT__ANCHORTEXT(0x0087, "text.anchortext"),
    TEXT__TEXTFLOW(0x0088, "text.textflow"),
    TEXT__FONTROTATION(0x0089, "text.fontrotation"),
    TEXT__IDOFNEXTSHAPE(0x008a, "text.idofnextshape"),
    TEXT__BIDIR(0x008b, "text.bidir"),
    TEXT__SINGLECLICKSELECTS(0x00bb, "text.singleclickselects"),
    TEXT__USEHOSTMARGINS(0x00bc, "text.usehostmargins"),
    TEXT__ROTATETEXTWITHSHAPE(0x00bd, "text.rotatetextwithshape"),
    TEXT__SIZESHAPETOFITTEXT(0x00be, "text.sizeshapetofittext"),
    TEXT__SIZE_TEXT_TO_FIT_SHAPE(0x00bf, "text.sizetexttofitshape", EscherPropertyTypesHolder.BOOLEAN),
    GEOTEXT__UNICODE(0x00c0, "geotext.unicode"),
    GEOTEXT__RTFTEXT(0x00c1, "geotext.rtftext"),
    GEOTEXT__ALIGNMENTONCURVE(0x00c2, "geotext.alignmentoncurve"),
    GEOTEXT__DEFAULTPOINTSIZE(0x00c3, "geotext.defaultpointsize"),
    GEOTEXT__TEXTSPACING(0x00c4, "geotext.textspacing"),
    GEOTEXT__FONTFAMILYNAME(0x00c5, "geotext.fontfamilyname"),
    GEOTEXT__REVERSEROWORDER(0x00f0, "geotext.reverseroworder"),
    GEOTEXT__HASTEXTEFFECT(0x00f1, "geotext.hastexteffect"),
    GEOTEXT__ROTATECHARACTERS(0x00f2, "geotext.rotatecharacters"),
    GEOTEXT__KERNCHARACTERS(0x00f3, "geotext.kerncharacters"),
    GEOTEXT__TIGHTORTRACK(0x00f4, "geotext.tightortrack"),
    GEOTEXT__STRETCHTOFITSHAPE(0x00f5, "geotext.stretchtofitshape"),
    GEOTEXT__CHARBOUNDINGBOX(0x00f6, "geotext.charboundingbox"),
    GEOTEXT__SCALETEXTONPATH(0x00f7, "geotext.scaletextonpath"),
    GEOTEXT__STRETCHCHARHEIGHT(0x00f8, "geotext.stretchcharheight"),
    GEOTEXT__NOMEASUREALONGPATH(0x00f9, "geotext.nomeasurealongpath"),
    GEOTEXT__BOLDFONT(0x00fa, "geotext.boldfont"),
    GEOTEXT__ITALICFONT(0x00fb, "geotext.italicfont"),
    GEOTEXT__UNDERLINEFONT(0x00fc, "geotext.underlinefont"),
    GEOTEXT__SHADOWFONT(0x00fd, "geotext.shadowfont"),
    GEOTEXT__SMALLCAPSFONT(0x00fe, "geotext.smallcapsfont"),
    GEOTEXT__STRIKETHROUGHFONT(0x00ff, "geotext.strikethroughfont"),
    BLIP__CROPFROMTOP(0x0100, "blip.cropfromtop"),
    BLIP__CROPFROMBOTTOM(0x0101, "blip.cropfrombottom"),
    BLIP__CROPFROMLEFT(0x0102, "blip.cropfromleft"),
    BLIP__CROPFROMRIGHT(0x0103, "blip.cropfromright"),
    BLIP__BLIPTODISPLAY(0x0104, "blip.bliptodisplay"),
    BLIP__BLIPFILENAME(0x0105, "blip.blipfilename"),
    BLIP__BLIPFLAGS(0x0106, "blip.blipflags"),
    BLIP__TRANSPARENTCOLOR(0x0107, "blip.transparentcolor"),
    BLIP__CONTRASTSETTING(0x0108, "blip.contrastsetting"),
    BLIP__BRIGHTNESSSETTING(0x0109, "blip.brightnesssetting"),
    BLIP__GAMMA(0x010a, "blip.gamma"),
    BLIP__PICTUREID(0x010b, "blip.pictureid"),
    BLIP__DOUBLEMOD(0x010c, "blip.doublemod"),
    BLIP__PICTUREFILLMOD(0x010d, "blip.picturefillmod"),
    BLIP__PICTURELINE(0x010e, "blip.pictureline"),
    BLIP__PRINTBLIP(0x010f, "blip.printblip"),
    BLIP__PRINTBLIPFILENAME(0x0110, "blip.printblipfilename"),
    BLIP__PRINTFLAGS(0x0111, "blip.printflags"),
    BLIP__NOHITTESTPICTURE(0x013c, "blip.nohittestpicture"),
    BLIP__PICTUREGRAY(0x013d, "blip.picturegray"),
    BLIP__PICTUREBILEVEL(0x013e, "blip.picturebilevel"),
    BLIP__PICTUREACTIVE(0x013f, "blip.pictureactive"),
    GEOMETRY__LEFT(0x0140, "geometry.left"),
    GEOMETRY__TOP(0x0141, "geometry.top"),
    GEOMETRY__RIGHT(0x0142, "geometry.right"),
    GEOMETRY__BOTTOM(0x0143, "geometry.bottom"),
    GEOMETRY__SHAPEPATH(0x0144, "geometry.shapepath", EscherPropertyTypesHolder.SHAPE_PATH),
    GEOMETRY__VERTICES(0x0145, "geometry.vertices", EscherPropertyTypesHolder.ARRAY),
    GEOMETRY__SEGMENTINFO(0x0146, "geometry.segmentinfo", EscherPropertyTypesHolder.ARRAY),
    GEOMETRY__ADJUSTVALUE(0x0147, "geometry.adjustvalue"),
    GEOMETRY__ADJUST2VALUE(0x0148, "geometry.adjust2value"),
    GEOMETRY__ADJUST3VALUE(0x0149, "geometry.adjust3value"),
    GEOMETRY__ADJUST4VALUE(0x014a, "geometry.adjust4value"),
    GEOMETRY__ADJUST5VALUE(0x014b, "geometry.adjust5value"),
    GEOMETRY__ADJUST6VALUE(0x014c, "geometry.adjust6value"),
    GEOMETRY__ADJUST7VALUE(0x014d, "geometry.adjust7value"),
    GEOMETRY__ADJUST8VALUE(0x014e, "geometry.adjust8value"),
    GEOMETRY__ADJUST9VALUE(0x014f, "geometry.adjust9value"),
    GEOMETRY__ADJUST10VALUE(0x0150, "geometry.adjust10value"),
    GEOMETRY__PCONNECTIONSITES(0x0151, "geometry.pConnectionSites"),
    GEOMETRY__PCONNECTIONSITESDIR(0x0152, "geometry.pConnectionSitesDir"),
    GEOMETRY__XLIMO(0x0153, "geometry.xLimo"),
    GEOMETRY__YLIMO(0x0154, "geometry.yLimo"),
    GEOMETRY__PADJUSTHANDLES(0x0155, "geometry.pAdjustHandles"),
    GEOMETRY__PGUIDES(0x0156, "geometry.pGuides"),
    GEOMETRY__PINSCRIBE(0x0157, "geometry.pInscribe"),
    GEOMETRY__CXK(0x0158, "geometry.cxk"),
    GEOMETRY__PFRAGMENTS(0x0159, "geometry.pFragments"),
    GEOMETRY__SHADOWOK(0x017a, "geometry.shadowOK"),
    GEOMETRY__3DOK(0x017b, "geometry.3dok"),
    GEOMETRY__LINEOK(0x017c, "geometry.lineok"),
    GEOMETRY__GEOTEXTOK(0x017d, "geometry.geotextok"),
    GEOMETRY__FILLSHADESHAPEOK(0x017e, "geometry.fillshadeshapeok"),
    GEOMETRY__FILLOK(0x017f, "geometry.fillok", EscherPropertyTypesHolder.BOOLEAN),
    FILL__FILLTYPE(0x0180, "fill.filltype"),
    FILL__FILLCOLOR(0x0181, "fill.fillcolor", EscherPropertyTypesHolder.RGB),
    FILL__FILLOPACITY(0x0182, "fill.fillopacity"),
    FILL__FILLBACKCOLOR(0x0183, "fill.fillbackcolor", EscherPropertyTypesHolder.RGB),
    FILL__BACKOPACITY(0x0184, "fill.backopacity"),
    FILL__CRMOD(0x0185, "fill.crmod"),
    FILL__PATTERNTEXTURE(0x0186, "fill.patterntexture"),
    FILL__BLIPFILENAME(0x0187, "fill.blipfilename"),
    FILL__BLIPFLAGS(0x0188, "fill.blipflags"),
    FILL__WIDTH(0x0189, "fill.width"),
    FILL__HEIGHT(0x018a, "fill.height"),
    FILL__ANGLE(0x018b, "fill.angle"),
    FILL__FOCUS(0x018c, "fill.focus"),
    FILL__TOLEFT(0x018d, "fill.toleft"),
    FILL__TOTOP(0x018e, "fill.totop"),
    FILL__TORIGHT(0x018f, "fill.toright"),
    FILL__TOBOTTOM(0x0190, "fill.tobottom"),
    FILL__RECTLEFT(0x0191, "fill.rectleft"),
    FILL__RECTTOP(0x0192, "fill.recttop"),
    FILL__RECTRIGHT(0x0193, "fill.rectright"),
    FILL__RECTBOTTOM(0x0194, "fill.rectbottom"),
    FILL__DZTYPE(0x0195, "fill.dztype"),
    FILL__SHADEPRESET(0x0196, "fill.shadepreset"),
    FILL__SHADECOLORS(0x0197, "fill.shadecolors", EscherPropertyTypesHolder.ARRAY),
    FILL__ORIGINX(0x0198, "fill.originx"),
    FILL__ORIGINY(0x0199, "fill.originy"),
    FILL__SHAPEORIGINX(0x019a, "fill.shapeoriginx"),
    FILL__SHAPEORIGINY(0x019b, "fill.shapeoriginy"),
    FILL__SHADETYPE(0x019c, "fill.shadetype"),
    FILL__FILLED(0x01bb, "fill.filled"),
    FILL__HITTESTFILL(0x01bc, "fill.hittestfill"),
    FILL__SHAPE(0x01bd, "fill.shape"),
    FILL__USERECT(0x01be, "fill.userect"),
    FILL__NOFILLHITTEST(0x01bf, "fill.nofillhittest", EscherPropertyTypesHolder.BOOLEAN),
    LINESTYLE__COLOR(0x01c0, "linestyle.color", EscherPropertyTypesHolder.RGB),
    LINESTYLE__OPACITY(0x01c1, "linestyle.opacity"),
    LINESTYLE__BACKCOLOR(0x01c2, "linestyle.backcolor", EscherPropertyTypesHolder.RGB),
    LINESTYLE__CRMOD(0x01c3, "linestyle.crmod"),
    LINESTYLE__LINETYPE(0x01c4, "linestyle.linetype"),
    LINESTYLE__FILLBLIP(0x01c5, "linestyle.fillblip"),
    LINESTYLE__FILLBLIPNAME(0x01c6, "linestyle.fillblipname"),
    LINESTYLE__FILLBLIPFLAGS(0x01c7, "linestyle.fillblipflags"),
    LINESTYLE__FILLWIDTH(0x01c8, "linestyle.fillwidth"),
    LINESTYLE__FILLHEIGHT(0x01c9, "linestyle.fillheight"),
    LINESTYLE__FILLDZTYPE(0x01ca, "linestyle.filldztype"),
    LINESTYLE__LINEWIDTH(0x01cb, "linestyle.linewidth"),
    LINESTYLE__LINEMITERLIMIT(0x01cc, "linestyle.linemiterlimit"),
    LINESTYLE__LINESTYLE(0x01cd, "linestyle.linestyle"),
    LINESTYLE__LINEDASHING(0x01ce, "linestyle.linedashing"),
    LINESTYLE__LINEDASHSTYLE(0x01cf, "linestyle.linedashstyle", EscherPropertyTypesHolder.ARRAY),
    LINESTYLE__LINESTARTARROWHEAD(0x01d0, "linestyle.linestartarrowhead"),
    LINESTYLE__LINEENDARROWHEAD(0x01d1, "linestyle.lineendarrowhead"),
    LINESTYLE__LINESTARTARROWWIDTH(0x01d2, "linestyle.linestartarrowwidth"),
    LINESTYLE__LINESTARTARROWLENGTH(0x01d3, "linestyle.linestartarrowlength"),
    LINESTYLE__LINEENDARROWWIDTH(0x01d4, "linestyle.lineendarrowwidth"),
    LINESTYLE__LINEENDARROWLENGTH(0x01d5, "linestyle.lineendarrowlength"),
    LINESTYLE__LINEJOINSTYLE(0x01d6, "linestyle.linejoinstyle"),
    LINESTYLE__LINEENDCAPSTYLE(0x01d7, "linestyle.lineendcapstyle"),
    LINESTYLE__ARROWHEADSOK(0x01fb, "linestyle.arrowheadsok"),
    LINESTYLE__ANYLINE(0x01fc, "linestyle.anyline"),
    LINESTYLE__HITLINETEST(0x01fd, "linestyle.hitlinetest"),
    LINESTYLE__LINEFILLSHAPE(0x01fe, "linestyle.linefillshape"),
    LINESTYLE__NOLINEDRAWDASH(0x01ff, "linestyle.nolinedrawdash", EscherPropertyTypesHolder.BOOLEAN),
    LINESTYLE__NOLINEDRAWDASH_LEFT(0x057F, "linestyle.nolinedrawdash.left", EscherPropertyTypesHolder.BOOLEAN),
    LINESTYLE__NOLINEDRAWDASH_TOP(0x05BF, "linestyle.nolinedrawdash.top", EscherPropertyTypesHolder.BOOLEAN),
    LINESTYLE__NOLINEDRAWDASH_BOTTOM(0x063F, "linestyle.nolinedrawdash.bottom", EscherPropertyTypesHolder.BOOLEAN),
    LINESTYLE__NOLINEDRAWDASH_RIGHT(0x05FF, "linestyle.nolinedrawdash.right", EscherPropertyTypesHolder.BOOLEAN),
    SHADOWSTYLE__TYPE(0x0200, "shadowstyle.type"),
    SHADOWSTYLE__COLOR(0x0201, "shadowstyle.color", EscherPropertyTypesHolder.RGB),
    SHADOWSTYLE__HIGHLIGHT(0x0202, "shadowstyle.highlight"),
    SHADOWSTYLE__CRMOD(0x0203, "shadowstyle.crmod"),
    SHADOWSTYLE__OPACITY(0x0204, "shadowstyle.opacity"),
    SHADOWSTYLE__OFFSETX(0x0205, "shadowstyle.offsetx"),
    SHADOWSTYLE__OFFSETY(0x0206, "shadowstyle.offsety"),
    SHADOWSTYLE__SECONDOFFSETX(0x0207, "shadowstyle.secondoffsetx"),
    SHADOWSTYLE__SECONDOFFSETY(0x0208, "shadowstyle.secondoffsety"),
    SHADOWSTYLE__SCALEXTOX(0x0209, "shadowstyle.scalextox"),
    SHADOWSTYLE__SCALEYTOX(0x020a, "shadowstyle.scaleytox"),
    SHADOWSTYLE__SCALEXTOY(0x020b, "shadowstyle.scalextoy"),
    SHADOWSTYLE__SCALEYTOY(0x020c, "shadowstyle.scaleytoy"),
    SHADOWSTYLE__PERSPECTIVEX(0x020d, "shadowstyle.perspectivex"),
    SHADOWSTYLE__PERSPECTIVEY(0x020e, "shadowstyle.perspectivey"),
    SHADOWSTYLE__WEIGHT(0x020f, "shadowstyle.weight"),
    SHADOWSTYLE__ORIGINX(0x0210, "shadowstyle.originx"),
    SHADOWSTYLE__ORIGINY(0x0211, "shadowstyle.originy"),
    SHADOWSTYLE__SHADOW(0x023e, "shadowstyle.shadow"),
    SHADOWSTYLE__SHADOWOBSURED(0x023f, "shadowstyle.shadowobscured"),
    PERSPECTIVE__TYPE(0x0240, "perspective.type"),
    PERSPECTIVE__OFFSETX(0x0241, "perspective.offsetx"),
    PERSPECTIVE__OFFSETY(0x0242, "perspective.offsety"),
    PERSPECTIVE__SCALEXTOX(0x0243, "perspective.scalextox"),
    PERSPECTIVE__SCALEYTOX(0x0244, "perspective.scaleytox"),
    PERSPECTIVE__SCALEXTOY(0x0245, "perspective.scalextoy"),
    PERSPECTIVE__SCALEYTOY(0x0246, "perspective.scaleytoy"),
    PERSPECTIVE__PERSPECTIVEX(0x0247, "perspective.perspectivex"),
    PERSPECTIVE__PERSPECTIVEY(0x0248, "perspective.perspectivey"),
    PERSPECTIVE__WEIGHT(0x0249, "perspective.weight"),
    PERSPECTIVE__ORIGINX(0x024a, "perspective.originx"),
    PERSPECTIVE__ORIGINY(0x024b, "perspective.originy"),
    PERSPECTIVE__PERSPECTIVEON(0x027f, "perspective.perspectiveon"),
    THREED__SPECULARAMOUNT(0x0280, "3d.specularamount"),
    THREED__DIFFUSEAMOUNT(0x0281, "3d.diffuseamount"),
    THREED__SHININESS(0x0282, "3d.shininess"),
    THREED__EDGETHICKNESS(0x0283, "3d.edgethickness"),
    THREED__EXTRUDEFORWARD(0x0284, "3d.extrudeforward"),
    THREED__EXTRUDEBACKWARD(0x0285, "3d.extrudebackward"),
    RESERVED646(0x0286, "reserved646"),
    THREED__EXTRUSIONCOLOR(0x0287, "3d.extrusioncolor", EscherPropertyTypesHolder.RGB),
    THREED__CRMOD(0x0288, "3d.crmod"),
    THREED__EXTRUSIONCOLOREXT(0x0289, "3d.extrusioncolorext"),
    RESERVED650(0x028A, "reserved650"),
    THREED__EXTRUSIONCOLOREXTMOD(0x028B, "3d.extrusioncolorextmod"),
    RESERVED652(0x028c, "reserved652"),
    RESERVED653(0x028d, "reserved653"),
    THREED__BOOLEAN_PROPERTIES(0x028f, "3d.booleanproperties"),
    THREED__EXTRUDEPLANE(0x029a, "3d.extrudeplane"),
    THREED__3DEFFECT(0x02bc, "3d.3deffect"),
    THREED__METALLIC(0x02bd, "3d.metallic"),
    THREED__USEEXTRUSIONCOLOR(0x02be, "3d.useextrusioncolor", EscherPropertyTypesHolder.RGB),
    THREED__LIGHTFACE(0x02bf, "3d.lightface"),
    THREEDSTYLE__YROTATIONANGLE(0x02c0, "3dstyle.yrotationangle"),
    THREEDSTYLE__XROTATIONANGLE(0x02c1, "3dstyle.xrotationangle"),
    THREEDSTYLE__ROTATIONAXISX(0x02c2, "3dstyle.rotationaxisx"),
    THREEDSTYLE__ROTATIONAXISY(0x02c3, "3dstyle.rotationaxisy"),
    THREEDSTYLE__ROTATIONAXISZ(0x02c4, "3dstyle.rotationaxisz"),
    THREEDSTYLE__ROTATIONANGLE(0x02c5, "3dstyle.rotationangle"),
    THREEDSTYLE__ROTATIONCENTERX(0x02c6, "3dstyle.rotationcenterx"),
    THREEDSTYLE__ROTATIONCENTERY(0x02c7, "3dstyle.rotationcentery"),
    THREEDSTYLE__ROTATIONCENTERZ(0x02c8, "3dstyle.rotationcenterz"),
    THREEDSTYLE__RENDERMODE(0x02c9, "3dstyle.rendermode"),
    THREEDSTYLE__TOLERANCE(0x02ca, "3dstyle.tolerance"),
    THREEDSTYLE__XVIEWPOINT(0x02cb, "3dstyle.xviewpoint"),
    THREEDSTYLE__YVIEWPOINT(0x02cc, "3dstyle.yviewpoint"),
    THREEDSTYLE__ZVIEWPOINT(0x02cd, "3dstyle.zviewpoint"),
    THREEDSTYLE__ORIGINX(0x02ce, "3dstyle.originx"),
    THREEDSTYLE__ORIGINY(0x02cf, "3dstyle.originy"),
    THREEDSTYLE__SKEWANGLE(0x02d0, "3dstyle.skewangle"),
    THREEDSTYLE__SKEWAMOUNT(0x02d1, "3dstyle.skewamount"),
    THREEDSTYLE__AMBIENTINTENSITY(0x02d2, "3dstyle.ambientintensity"),
    THREEDSTYLE__KEYX(0x02d3, "3dstyle.keyx"),
    THREEDSTYLE__KEYY(0x02d4, "3dstyle.keyy"),
    THREEDSTYLE__KEYZ(0x02d5, "3dstyle.keyz"),
    THREEDSTYLE__KEYINTENSITY(0x02d6, "3dstyle.keyintensity"),
    THREEDSTYLE__FILLX(0x02d7, "3dstyle.fillx"),
    THREEDSTYLE__FILLY(0x02d8, "3dstyle.filly"),
    THREEDSTYLE__FILLZ(0x02d9, "3dstyle.fillz"),
    THREEDSTYLE__FILLINTENSITY(0x02da, "3dstyle.fillintensity"),
    THREEDSTYLE__CONSTRAINROTATION(0x02fb, "3dstyle.constrainrotation"),
    THREEDSTYLE__ROTATIONCENTERAUTO(0x02fc, "3dstyle.rotationcenterauto"),
    THREEDSTYLE__PARALLEL(0x02fd, "3dstyle.parallel"),
    THREEDSTYLE__KEYHARSH(0x02fe, "3dstyle.keyharsh"),
    THREEDSTYLE__FILLHARSH(0x02ff, "3dstyle.fillharsh"),
    SHAPE__MASTER(0x0301, "shape.master"),
    SHAPE__CONNECTORSTYLE(0x0303, "shape.connectorstyle"),
    SHAPE__BLACKANDWHITESETTINGS(0x0304, "shape.blackandwhitesettings"),
    SHAPE__WMODEPUREBW(0x0305, "shape.wmodepurebw"),
    SHAPE__WMODEBW(0x0306, "shape.wmodebw"),
    SHAPE__OLEICON(0x033a, "shape.oleicon"),
    SHAPE__PREFERRELATIVERESIZE(0x033b, "shape.preferrelativeresize"),
    SHAPE__LOCKSHAPETYPE(0x033c, "shape.lockshapetype"),
    SHAPE__DELETEATTACHEDOBJECT(0x033e, "shape.deleteattachedobject"),
    SHAPE__BACKGROUNDSHAPE(0x033f, "shape.backgroundshape"),
    CALLOUT__CALLOUTTYPE(0x0340, "callout.callouttype"),
    CALLOUT__XYCALLOUTGAP(0x0341, "callout.xycalloutgap"),
    CALLOUT__CALLOUTANGLE(0x0342, "callout.calloutangle"),
    CALLOUT__CALLOUTDROPTYPE(0x0343, "callout.calloutdroptype"),
    CALLOUT__CALLOUTDROPSPECIFIED(0x0344, "callout.calloutdropspecified"),
    CALLOUT__CALLOUTLENGTHSPECIFIED(0x0345, "callout.calloutlengthspecified"),
    CALLOUT__ISCALLOUT(0x0379, "callout.iscallout"),
    CALLOUT__CALLOUTACCENTBAR(0x037a, "callout.calloutaccentbar"),
    CALLOUT__CALLOUTTEXTBORDER(0x037b, "callout.callouttextborder"),
    CALLOUT__CALLOUTMINUSX(0x037c, "callout.calloutminusx"),
    CALLOUT__CALLOUTMINUSY(0x037d, "callout.calloutminusy"),
    CALLOUT__DROPAUTO(0x037e, "callout.dropauto"),
    CALLOUT__LENGTHSPECIFIED(0x037f, "callout.lengthspecified"),
    GROUPSHAPE__SHAPENAME(0x0380, "groupshape.shapename"),
    GROUPSHAPE__DESCRIPTION(0x0381, "groupshape.description"),
    GROUPSHAPE__HYPERLINK(0x0382, "groupshape.hyperlink"),
    GROUPSHAPE__WRAPPOLYGONVERTICES(0x0383, "groupshape.wrappolygonvertices", EscherPropertyTypesHolder.ARRAY),
    GROUPSHAPE__WRAPDISTLEFT(0x0384, "groupshape.wrapdistleft"),
    GROUPSHAPE__WRAPDISTTOP(0x0385, "groupshape.wrapdisttop"),
    GROUPSHAPE__WRAPDISTRIGHT(0x0386, "groupshape.wrapdistright"),
    GROUPSHAPE__WRAPDISTBOTTOM(0x0387, "groupshape.wrapdistbottom"),
    GROUPSHAPE__REGROUPID(0x0388, "groupshape.regroupid"),
    GROUPSHAPE__UNUSED906(0x038A, "unused906"),
    GROUPSHAPE__TOOLTIP(0x038D, "groupshape.wzTooltip"),
    GROUPSHAPE__SCRIPT(0x038E, "groupshape.wzScript"),
    GROUPSHAPE__POSH(0x038F, "groupshape.posh"),
    GROUPSHAPE__POSRELH(0x0390, "groupshape.posrelh"),
    GROUPSHAPE__POSV(0x0391, "groupshape.posv"),
    GROUPSHAPE__POSRELV(0x0392, "groupshape.posrelv"),
    GROUPSHAPE__HR_PCT(0x0393, "groupshape.pctHR"),
    GROUPSHAPE__HR_ALIGN(0x0394, "groupshape.alignHR"),
    GROUPSHAPE__HR_HEIGHT(0x0395, "groupshape.dxHeightHR"),
    GROUPSHAPE__HR_WIDTH(0x0396, "groupshape.dxWidthHR"),
    GROUPSHAPE__SCRIPTEXT(0x0397, "groupshape.wzScriptExtAttr"),
    GROUPSHAPE__SCRIPTLANG(0x0398, "groupshape.scriptLang"),
    GROUPSHAPE__BORDERTOPCOLOR(0x039B, "groupshape.borderTopColor"),
    GROUPSHAPE__BORDERLEFTCOLOR(0x039C, "groupshape.borderLeftColor"),
    GROUPSHAPE__BORDERBOTTOMCOLOR(0x039D, "groupshape.borderBottomColor"),
    GROUPSHAPE__BORDERRIGHTCOLOR(0x039E, "groupshape.borderRightColor"),
    GROUPSHAPE__TABLEPROPERTIES(0x039F, "groupshape.tableProperties"),
    GROUPSHAPE__TABLEROWPROPERTIES(0x03A0, "groupshape.tableRowProperties", EscherPropertyTypesHolder.ARRAY),
    GROUPSHAPE__WEBBOT(0x03A5, "groupshape.wzWebBot"),
    GROUPSHAPE__METROBLOB(0x03A9, "groupshape.metroBlob"),
    GROUPSHAPE__ZORDER(0x03AA, "groupshape.dhgt"),
    GROUPSHAPE__EDITEDWRAP(0x03b9, "groupshape.editedwrap"),
    GROUPSHAPE__BEHINDDOCUMENT(0x03ba, "groupshape.behinddocument"),
    GROUPSHAPE__ONDBLCLICKNOTIFY(0x03bb, "groupshape.ondblclicknotify"),
    GROUPSHAPE__ISBUTTON(0x03bc, "groupshape.isbutton"),
    GROUPSHAPE__1DADJUSTMENT(0x03bd, "groupshape.1dadjustment"),
    GROUPSHAPE__HIDDEN(0x03be, "groupshape.hidden"),
    GROUPSHAPE__FLAGS(0x03bf, "groupshape.groupShapeBooleanProperties"),
    UNKNOWN(0xffff, "unknown")
    ;

    /** the property number part of the property id, i.e. the id without is_blip/is_complex flag */
    public final short propNumber;
    public final String propName;
    public final EscherPropertyTypesHolder holder;

    EscherPropertyTypes(int propNumber, String name) {
        this(propNumber, name, EscherPropertyTypesHolder.UNKNOWN);
    }

    EscherPropertyTypes(int propNumber, String propName, EscherPropertyTypesHolder holder) {
        this.propNumber = (short) propNumber;
        this.propName = propName;
        this.holder = holder;
    }

    public short getPropertyId() {
        return propNumber;
    }

    private static final Map<Short, EscherPropertyTypes> LOOKUP = Collections.unmodifiableMap(
            Stream.of(values()).collect(Collectors.toMap(EscherPropertyTypes::getPropertyId, Function.identity())));

    public static EscherPropertyTypes forPropertyID(int propertyId) {
        EscherPropertyTypes rt = LOOKUP.get((short)(propertyId & 0x3FFF));
        return (rt != null) ? rt : EscherPropertyTypes.UNKNOWN;
    }

}

