package klev

object `8` : Day {
    data class Node(
        val value: String,
        var left: Node? = null,
        var right: Node? = null,
    )

    private fun List<String>.createLinkedNodes(): List<Node> {
        val nodes =
            map { row ->
                Node(row.filter { it != ' ' }.split("=").first(), null, null)
            }

        nodes.forEachIndexed { index, node ->
            val (value, leftRight) = this[index].filter { it != ' ' }.split("=")
            val (left, right) = leftRight.drop(1).dropLast(1).split(",")
            require(value == node.value)
            node.left = nodes.find { it.value == left }
            node.right = nodes.find { it.value == right }
        }
        return nodes
    }

    override fun firstSolution(input: List<String>): String {
        val instructions = input[0]
        val nodes = input.drop(2).createLinkedNodes()

        var currentNode = nodes.first { it.value == "AAA" }
        var count = 0
        var currentInstruction = 0
        while (currentNode.value != "ZZZ") {
            if (currentInstruction >= instructions.length) {
                currentInstruction = 0
            }
            currentNode = currentNode.getNextNode(instructions[currentInstruction])
            currentInstruction++
            count++
        }
        return count.toString()
    }

    private fun Node.getNextNode(instruction: Char) =
        if (instruction == 'L') {
            requireNotNull(left)
        } else if (instruction == 'R') {
            requireNotNull(right)
        } else {
            throw IllegalArgumentException()
        }

    override fun secondSolution(input: List<String>): String {
        val instructions = input[0]
        val nodes = input.drop(2).createLinkedNodes()
        val startNodes = nodes.filter { it.value.last() == 'A' }
        val stepsForEachNode =
            startNodes.map {
                var currentNode = it
                var count = 0L
                var currentInstruction = 0
                while (!currentNode.value.endsWith('Z')) {
                    if (currentInstruction >= instructions.length) {
                        currentInstruction = 0
                    }
                    currentNode = currentNode.getNextNode(instructions[currentInstruction])

                    currentInstruction++
                    count++
                }
                count
            }

        return findLCMOfListOfNumbers(stepsForEachNode).toString()
    }

    private fun findLCM(
        a: Long,
        b: Long,
    ): Long {
        val larger = if (a > b) a else b
        val maxLcm = a * b
        var lcm = larger
        while (lcm <= maxLcm) {
            if (lcm % a == 0L && lcm % b == 0L) {
                return lcm
            }
            lcm += larger
        }
        return maxLcm
    }

    private fun findLCMOfListOfNumbers(numbers: List<Long>): Long {
        var result = numbers[0]
        for (i in 1 until numbers.size) {
            result = findLCM(result, numbers[i])
        }
        return result
    }

    override fun input() =
        """
        LLLLLLLRRRLRRRLRLRLRLRRLLRRRLRLLRRRLLRRLRRLRRLRLRRLRLRRRLRRLRLRRRLRRLRRLRLRRLLRLLRLRRRLRRLRLLLLRRLLLLRLRLRLRRRLRLRLLLRLRRRLRRRLRRRLRLRRLRRRLRLLLRLLRRLRRRLRRLRRLRRLRLRRRLRLRLRLLRRRLRRRLRRLRRRLLLRRLRRLRRRLRLRRRLRRRLRLRRLRRRLRLRRLRLRRLRRRLRLRRLRLLRRRLLRLRRLRRRLLLRLRRLRRRR

        DGK = (KVQ, XHR)
        KTC = (TVB, MTH)
        CGR = (VVK, BKP)
        LCG = (FQC, KHX)
        PSZ = (FSF, QSM)
        FBJ = (FHP, SPX)
        KJD = (NRQ, VDH)
        NCM = (JPJ, KNG)
        TXH = (HNK, VHQ)
        NND = (TRC, DFM)
        JQN = (CNX, XLD)
        RHB = (CDG, GBT)
        JBN = (PXV, GVN)
        DFC = (JRN, TXH)
        TXG = (CHT, VBL)
        XXQ = (JDC, JGV)
        SVF = (FVD, LHQ)
        FVK = (LCG, RNB)
        XKT = (MPF, XJJ)
        MHB = (JSJ, VQM)
        FVC = (HXF, VVN)
        JJR = (VNS, SLM)
        RMT = (GDS, XHP)
        CHT = (PXS, VLF)
        SFJ = (XGC, LPM)
        BJL = (XDN, VXN)
        PQK = (NHS, DVB)
        PDB = (JPQ, TVJ)
        RGL = (DNN, NCN)
        KRN = (SBL, PHL)
        MTF = (PJL, KQR)
        BTL = (CCF, LDP)
        NLV = (CPM, HVL)
        GCQ = (QMF, JVH)
        KVH = (VKD, PQG)
        RLB = (GSS, JVP)
        QRB = (TNL, DKN)
        JFV = (RDR, NSB)
        BFC = (LGH, XLX)
        HGQ = (SLM, VNS)
        FQC = (VFQ, BXC)
        DDS = (XHR, KVQ)
        VQV = (SFT, BFQ)
        XFD = (HVV, FLH)
        TVP = (XQF, KSS)
        GBH = (NPX, LDB)
        KHL = (MGS, MMD)
        NPX = (BJL, SFF)
        VMG = (DHX, GVC)
        RTJ = (XRF, BPK)
        TLM = (NCG, QBB)
        LXS = (TVB, MTH)
        XNM = (QFL, KQK)
        KQR = (QRD, JBN)
        JQD = (DNN, NCN)
        QCF = (MXL, MXL)
        QMH = (NKG, SDJ)
        NKK = (MCB, RLB)
        MPJ = (BTL, JTF)
        TLS = (VPJ, LMD)
        XJB = (LML, TKZ)
        HGF = (HBF, QHB)
        KNJ = (QKM, XLR)
        XCF = (QCJ, HTN)
        HFS = (NKC, JFV)
        QLS = (QBB, NCG)
        QFL = (NXQ, QBN)
        MTH = (FLN, LQR)
        VND = (KMM, MQH)
        NQQ = (VVH, NDL)
        BTV = (QSM, FSF)
        SLT = (NRQ, VDH)
        NKG = (TBV, XCV)
        SLM = (LBN, HPK)
        CMQ = (KKS, VBH)
        JTF = (LDP, CCF)
        VFC = (GKH, KPS)
        KCC = (JVM, MTF)
        KFP = (MVX, NMX)
        NQF = (QSK, KCC)
        GGC = (VBV, TJR)
        QQS = (NKK, NQC)
        LXK = (FXC, QBC)
        DVQ = (TFF, LKB)
        PBL = (BGQ, FHQ)
        KHV = (BVJ, XSD)
        LDB = (SFF, BJL)
        RJG = (LJB, CJM)
        RCX = (QTB, PPL)
        FLH = (HSX, KVX)
        XTV = (HST, VCC)
        GDC = (CMH, NCT)
        RDP = (FKR, GHJ)
        NXM = (PVV, KRX)
        SCQ = (MFN, GRB)
        MRT = (XGT, VLK)
        DHJ = (XHP, GDS)
        XFL = (TJK, QMH)
        XQF = (CCQ, RPH)
        CLV = (CKD, CCD)
        CMT = (NCD, XDM)
        NCT = (SXG, CLF)
        JSS = (GMJ, LJC)
        TLQ = (CRC, DXQ)
        DMJ = (HHB, DRV)
        JBH = (FVC, HDX)
        QXK = (QSB, JBH)
        DQN = (QMD, GDN)
        SDH = (PRH, BCX)
        QSB = (HDX, FVC)
        MTP = (VVG, SPN)
        CTM = (MFG, GGJ)
        HND = (MNV, TXG)
        MJS = (DMJ, QQG)
        JNL = (LKB, TFF)
        QLL = (FKM, HNH)
        PNM = (PQR, NRL)
        VSF = (LPM, XGC)
        QBC = (QQS, MVF)
        BFM = (FBP, BQJ)
        KNG = (RTJ, CXN)
        VFQ = (HFS, LBS)
        LKB = (QVB, TXF)
        KQD = (CDJ, CDJ)
        ZZZ = (DHJ, RMT)
        XKX = (HVP, NJF)
        GSL = (QMS, DHM)
        PNT = (CDJ, GJZ)
        KBN = (CMQ, JBG)
        DNX = (SFM, GFJ)
        NMX = (XRR, LKL)
        VPJ = (PSK, GQL)
        XQD = (QCF, QCF)
        HRM = (RHB, XXJ)
        LCL = (MRT, FMB)
        DRG = (RNB, LCG)
        BKP = (QLL, MMQ)
        FSF = (SLR, XGV)
        KHX = (BXC, VFQ)
        SXG = (NHL, KGK)
        MJD = (TDH, RFP)
        NRL = (CSG, MPT)
        FBP = (QGC, GXH)
        HDT = (LHQ, FVD)
        BMP = (RMG, JXM)
        NCN = (SLT, KJD)
        NXQ = (JPP, QQL)
        NGV = (HNJ, VVQ)
        NPN = (MXL, NJK)
        FVD = (XBQ, NKF)
        GQM = (QCG, GGC)
        QBP = (XML, HND)
        VQT = (BTL, JTF)
        HKP = (CMH, NCT)
        JHP = (NDL, VVH)
        FRL = (SHD, FNH)
        FLN = (NVL, HGF)
        MXH = (QSD, KKR)
        BGL = (XCX, RFC)
        RSQ = (MKH, TLS)
        VML = (RJM, CXK)
        XHP = (MJS, DNP)
        GRV = (XRN, TVQ)
        GKH = (BCF, VSD)
        SPH = (MVX, NMX)
        TLD = (LFR, GFQ)
        LML = (QKS, NND)
        PKT = (VXC, CMF)
        LLQ = (THT, GRV)
        CKD = (SPB, QDV)
        KRM = (JQV, JNG)
        RNS = (HJJ, MLV)
        FKR = (FKK, BHN)
        XNH = (SCQ, KLF)
        GDN = (LBL, FHT)
        CRB = (NHQ, QRB)
        JKQ = (DPT, KBN)
        NJF = (RJG, NGF)
        NRT = (NSK, CSL)
        LJR = (VTT, HCQ)
        HLK = (DFC, DPV)
        PQR = (MPT, CSG)
        DNF = (NJF, HVP)
        MPV = (HJD, XSF)
        TBV = (XTJ, SVH)
        LKX = (XFJ, HBM)
        KTP = (CGR, RVR)
        HVL = (BJH, QXK)
        GJD = (XJJ, MPF)
        HLC = (VVQ, HNJ)
        JTX = (NCD, XDM)
        CSG = (MFF, RKT)
        PCH = (PGJ, GQM)
        SFF = (VXN, XDN)
        TCF = (KNG, JPJ)
        LDP = (XFD, SBS)
        XCR = (GJD, XKT)
        QBM = (GFB, LRH)
        CLP = (RJM, CXK)
        MTT = (HST, VCC)
        TQL = (BPM, GGT)
        LFR = (HNF, RDP)
        JHN = (CMT, JTX)
        XCX = (CHG, CHG)
        XGT = (HLK, QJF)
        TQS = (TKL, MNF)
        KFL = (HGQ, JJR)
        LHQ = (XBQ, NKF)
        CCQ = (DBP, HHC)
        TKL = (VDN, PBP)
        LBX = (BXM, SDH)
        XLX = (NGJ, LHJ)
        GVN = (BPG, TNK)
        CCX = (HCQ, VTT)
        KQK = (QBN, NXQ)
        NQC = (MCB, RLB)
        MPF = (DFT, SBG)
        BNH = (MLV, HJJ)
        CJM = (LBH, TNM)
        CND = (VKB, PGQ)
        HXM = (GMJ, LJC)
        TKZ = (NND, QKS)
        RKT = (LNQ, KFL)
        GXH = (RQP, LBX)
        TFF = (QVB, TXF)
        LNK = (FDC, MXH)
        KPK = (BNH, RNS)
        QQG = (HHB, DRV)
        MFP = (PQK, NBF)
        VVK = (QLL, MMQ)
        GFB = (RHN, LCN)
        PPD = (QCJ, HTN)
        FXV = (BPM, GGT)
        KSS = (CCQ, RPH)
        KCM = (LTB, PCH)
        RHN = (FXV, TQL)
        LFV = (DDJ, NQF)
        JKG = (BGQ, FHQ)
        MBS = (RQJ, LDQ)
        HHC = (NGV, HLC)
        CCD = (QDV, SPB)
        RFM = (FTB, HSB)
        QCG = (VBV, TJR)
        GRH = (LXK, LGQ)
        CDJ = (QQJ, BFC)
        THT = (TVQ, XRN)
        QRD = (PXV, GVN)
        VHQ = (SXV, GJL)
        MLV = (VRM, MCP)
        XRR = (CLV, PBJ)
        NMS = (DGK, DDS)
        JPS = (JKT, KHL)
        DJJ = (QMS, DHM)
        MFG = (TLQ, VQD)
        GPQ = (SHL, BNR)
        QVB = (GDC, HKP)
        LNN = (CMF, VXC)
        VBQ = (LNN, PKT)
        MMS = (SVV, HRM)
        BGJ = (HXM, JSS)
        QCK = (JSJ, VQM)
        PKB = (XNH, JQH)
        BCF = (TQR, TLL)
        JRN = (VHQ, HNK)
        SHL = (DMK, JBX)
        LRG = (NSK, CSL)
        NJV = (FJH, TXC)
        GHQ = (FSB, HFX)
        LHN = (TLS, MKH)
        HBF = (BMP, GLM)
        DTP = (DVQ, JNL)
        FXR = (FTB, HSB)
        PDS = (XLD, CNX)
        SXV = (CPC, JNF)
        QMF = (GGF, JDP)
        JVP = (GPC, DNX)
        RMG = (HRF, PKB)
        LRH = (LCN, RHN)
        HVP = (RJG, NGF)
        TRC = (VKX, RQL)
        PJL = (QRD, JBN)
        HNK = (GJL, SXV)
        CHM = (NBF, PQK)
        PGH = (KMM, MQH)
        SDN = (MFP, CHM)
        DMK = (VRP, NNX)
        MRR = (NGK, SMQ)
        QDV = (NDM, JPT)
        PGJ = (QCG, GGC)
        BVJ = (NLV, HBR)
        PGQ = (BGK, GBH)
        LKL = (CLV, PBJ)
        FDC = (KKR, QSD)
        JDP = (PDB, PTX)
        NJJ = (HSJ, GRH)
        TVJ = (HDT, SVF)
        NJK = (RBV, ZZZ)
        HHN = (DPP, TLD)
        QMS = (BLS, TQS)
        QVR = (CVB, BNJ)
        FFQ = (RMJ, HGZ)
        LGQ = (QBC, FXC)
        JPP = (RSG, KTG)
        DPV = (TXH, JRN)
        HBR = (CPM, HVL)
        NSK = (JQN, PDS)
        SBS = (HVV, FLH)
        BFQ = (VBQ, JPB)
        LBN = (LXJ, CCR)
        RBD = (KRM, PNX)
        NQX = (LML, LML)
        XSA = (QKS, NND)
        NDB = (HFX, FSB)
        QMD = (LBL, FHT)
        XTJ = (JDT, JDT)
        GLH = (SHL, BNR)
        FXC = (MVF, QQS)
        HSX = (NFN, LVG)
        JNF = (JJH, FNR)
        CXK = (SPC, TVP)
        GGF = (PDB, PTX)
        XBQ = (QNX, JCQ)
        LJC = (SFJ, VSF)
        MMD = (XLK, CND)
        HFG = (JKT, KHL)
        NHQ = (TNL, DKN)
        JVM = (KQR, PJL)
        CGH = (RTC, VFC)
        HNF = (GHJ, FKR)
        TMF = (NMS, GJH)
        NGJ = (NXM, BDB)
        MRM = (JKQ, MPS)
        QTC = (JSS, HXM)
        TNM = (JFF, QXR)
        DHK = (LJR, CCX)
        XSB = (MRR, CXC)
        XRN = (XDP, QBP)
        XCV = (XTJ, SVH)
        VVA = (QSM, FSF)
        NKC = (RDR, NSB)
        MXL = (RBV, RBV)
        PTX = (TVJ, JPQ)
        VRL = (NQX, XJB)
        RQK = (MPS, JKQ)
        PBJ = (CKD, CCD)
        VRP = (DQN, QLC)
        KLF = (MFN, GRB)
        XXJ = (GBT, CDG)
        HST = (QHV, MMS)
        SFT = (JPB, VBQ)
        NRR = (LCL, MQR)
        CSL = (JQN, PDS)
        LHJ = (BDB, NXM)
        TXK = (DHK, KLC)
        CDK = (XCX, XCX)
        FHT = (NGQ, JHN)
        QQJ = (LGH, XLX)
        BQJ = (GXH, QGC)
        TTA = (QKM, XLR)
        TVB = (FLN, LQR)
        PPL = (FRL, NCX)
        SPS = (XFJ, HBM)
        SVH = (JDT, VRL)
        QBB = (PXG, MTP)
        JSJ = (VVB, NRR)
        KKS = (RGL, JQD)
        JDT = (NQX, NQX)
        GKQ = (LLT, JRH)
        VVH = (BPT, KRN)
        JCQ = (CRB, PBS)
        QXR = (BTV, PSZ)
        VQR = (RCX, KKP)
        QSM = (SLR, XGV)
        JKD = (JDC, JGV)
        XLD = (LFS, QVR)
        TJK = (NKG, SDJ)
        PVV = (HDK, VQV)
        BDB = (PVV, KRX)
        MPS = (KBN, DPT)
        FHP = (PPD, XCF)
        HTN = (KCM, PXC)
        GHJ = (BHN, FKK)
        JCC = (LQM, KVH)
        LQR = (HGF, NVL)
        LGM = (DDJ, NQF)
        NJN = (QCF, NPN)
        PRH = (DFF, DFF)
        XDM = (FBJ, PJM)
        HFN = (KRS, XSB)
        GLM = (JXM, RMG)
        RQP = (BXM, SDH)
        BPG = (QJT, KTP)
        JPB = (LNN, PKT)
        DKN = (CJD, BGR)
        CDG = (GSL, DJJ)
        XDN = (CGM, VMG)
        NQP = (SKT, JCC)
        DNP = (QQG, DMJ)
        NNX = (DQN, QLC)
        FTB = (JFL, VJJ)
        FHQ = (SMJ, XFK)
        GGT = (KPK, LNT)
        NGF = (LJB, CJM)
        QFX = (KCN, TMF)
        NKF = (JCQ, QNX)
        DBP = (NGV, HLC)
        RBV = (RMT, DHJ)
        NML = (MBV, VCG)
        KXJ = (MXH, FDC)
        GFQ = (RDP, HNF)
        SHD = (CMG, CTM)
        GTX = (LNK, KXJ)
        HXF = (KTC, LXS)
        CMM = (NQP, SBR)
        SDJ = (TBV, XCV)
        CHG = (RMJ, RMJ)
        DPT = (CMQ, JBG)
        BGR = (RLM, NML)
        THM = (XQD, NJN)
        HJJ = (MCP, VRM)
        NRQ = (JHR, GCQ)
        KKR = (HSN, NJJ)
        KVX = (LVG, NFN)
        LTT = (TLD, DPP)
        NVL = (QHB, HBF)
        CXN = (XRF, BPK)
        KLC = (CCX, LJR)
        JDC = (DNF, XKX)
        MGS = (XLK, CND)
        RLM = (VCG, MBV)
        VDN = (NMQ, TPR)
        HSB = (JFL, VJJ)
        HDS = (KLC, DHK)
        XSD = (NLV, HBR)
        HJD = (NJQ, PBQ)
        CGM = (DHX, GVC)
        LDQ = (PBL, JKG)
        RDR = (XHQ, MGQ)
        GPC = (GFJ, SFM)
        NQT = (KRS, XSB)
        TDH = (RBD, XLP)
        QJF = (DFC, DPV)
        VNS = (HPK, LBN)
        QSD = (NJJ, HSN)
        JHR = (QMF, JVH)
        SMQ = (FXR, RFM)
        CMG = (MFG, GGJ)
        NKQ = (VFC, RTC)
        VXC = (LHN, RSQ)
        DHX = (LCT, XNM)
        TCX = (NQT, HFN)
        DRV = (TFN, QBM)
        JPT = (GQX, XCR)
        HRF = (JQH, XNH)
        MCS = (BGJ, QTC)
        PQG = (NCM, TCF)
        XHR = (PJK, VPN)
        MLX = (PGH, VND)
        MKH = (VPJ, LMD)
        TJR = (VQT, MPJ)
        VLF = (GLG, QFX)
        JNG = (KLR, MPV)
        HDK = (BFQ, SFT)
        HFX = (MLX, SPL)
        BXC = (HFS, LBS)
        CCT = (GTX, HPT)
        VLK = (HLK, QJF)
        NCD = (PJM, FBJ)
        VGT = (JNL, DVQ)
        LMD = (PSK, GQL)
        KRX = (HDK, VQV)
        QNX = (CRB, PBS)
        NJQ = (GHQ, NDB)
        TNV = (FBP, BQJ)
        GNR = (XQD, NJN)
        KKP = (QTB, PPL)
        DBX = (KCQ, CPS)
        VRM = (TLM, QLS)
        LVG = (BRP, NJV)
        NHL = (SPS, LKX)
        MNV = (VBL, CHT)
        PJK = (HHN, LTT)
        VBH = (JQD, RGL)
        GRB = (NKQ, CGH)
        SKT = (KVH, LQM)
        TPR = (RXR, KHV)
        VVB = (LCL, MQR)
        VKX = (MRM, RQK)
        LTB = (PGJ, GQM)
        QCJ = (KCM, PXC)
        BGQ = (SMJ, SMJ)
        RCV = (NQQ, JHP)
        DHM = (TQS, BLS)
        KRS = (CXC, MRR)
        JFL = (BLT, PNM)
        TXC = (NRT, LRG)
        MVX = (LKL, XRR)
        QSK = (JVM, MTF)
        BGK = (LDB, NPX)
        GJZ = (BFC, QQJ)
        PXC = (LTB, PCH)
        HMQ = (BGJ, QTC)
        RXR = (BVJ, XSD)
        BXM = (PRH, BCX)
        FJH = (LRG, NRT)
        GJH = (DGK, DDS)
        BPT = (SBL, PHL)
        RQL = (RQK, MRM)
        SJB = (RQJ, LDQ)
        NFN = (NJV, BRP)
        MND = (NQQ, JHP)
        NMQ = (KHV, RXR)
        XGV = (TXK, HDS)
        SPC = (KSS, XQF)
        RMJ = (SMR, QRS)
        CNX = (LFS, QVR)
        KLR = (HJD, XSF)
        XLP = (KRM, PNX)
        LPM = (CMM, PHF)
        FNR = (CCT, VTP)
        NGQ = (CMT, JTX)
        CCR = (BFM, TNV)
        LCN = (FXV, TQL)
        HVV = (HSX, KVX)
        FSB = (MLX, SPL)
        GGJ = (TLQ, VQD)
        NHS = (DRG, FVK)
        RQJ = (PBL, JKG)
        VCC = (MMS, QHV)
        HDX = (VVN, HXF)
        VQM = (NRR, VVB)
        TFN = (GFB, LRH)
        QRS = (VQR, MDS)
        HBM = (VTQ, SDN)
        CCF = (SBS, XFD)
        VCG = (HMQ, MCS)
        NBF = (DVB, NHS)
        DVB = (FVK, DRG)
        PGB = (TDH, RFP)
        XRF = (KFP, SPH)
        KMM = (PDJ, GQN)
        KTG = (GGQ, HNR)
        BJH = (JBH, QSB)
        JJH = (CCT, VTP)
        LBH = (JFF, JFF)
        GLG = (TMF, KCN)
        TQR = (THM, GNR)
        MQH = (GQN, PDJ)
        MQR = (FMB, MRT)
        FNH = (CTM, CMG)
        SMR = (VQR, MDS)
        GDS = (DNP, MJS)
        LCT = (KQK, QFL)
        VKB = (GBH, BGK)
        VTQ = (CHM, MFP)
        TNK = (QJT, KTP)
        HNJ = (VVS, GCX)
        JKT = (MMD, MGS)
        PBP = (TPR, NMQ)
        CPS = (KNJ, RFZ)
        RNB = (KHX, FQC)
        CMF = (LHN, RSQ)
        HPK = (CCR, LXJ)
        MFN = (NKQ, CGH)
        HHB = (QBM, TFN)
        DDJ = (QSK, KCC)
        DFM = (RQL, VKX)
        FKM = (GKQ, VJG)
        HSJ = (LGQ, LXK)
        HPT = (KXJ, LNK)
        BNR = (JBX, DMK)
        GJL = (CPC, JNF)
        DFF = (KCQ, KCQ)
        MCB = (GSS, JVP)
        CPC = (JJH, FNR)
        XLR = (MJK, DSM)
        SBG = (JDG, XFL)
        XSF = (NJQ, PBQ)
        NGK = (RFM, FXR)
        HSN = (GRH, HSJ)
        LQM = (PQG, VKD)
        VXN = (VMG, CGM)
        PSK = (VGT, DTP)
        JQH = (KLF, SCQ)
        RJM = (SPC, TVP)
        VSD = (TLL, TQR)
        KCN = (GJH, NMS)
        QHB = (GLM, BMP)
        FMB = (VLK, XGT)
        GBT = (DJJ, GSL)
        LGH = (NGJ, LHJ)
        SLR = (HDS, TXK)
        VVQ = (GCX, VVS)
        MDS = (RCX, KKP)
        KVQ = (VPN, PJK)
        CLF = (NHL, KGK)
        XFK = (KQD, PNT)
        CJD = (NML, RLM)
        MCP = (TLM, QLS)
        SPL = (PGH, VND)
        GSS = (GPC, DNX)
        RPH = (DBP, HHC)
        HNR = (XXQ, JKD)
        VBV = (VQT, MPJ)
        PHF = (NQP, SBR)
        BRP = (FJH, TXC)
        AAA = (RMT, DHJ)
        PBQ = (GHQ, NDB)
        PXG = (VVG, SPN)
        PNX = (JQV, JNG)
        XHQ = (SJB, MBS)
        VBL = (VLF, PXS)
        VVG = (MTT, XTV)
        PXS = (GLG, QFX)
        MMQ = (FKM, HNH)
        PHG = (HFN, NQT)
        MFF = (KFL, LNQ)
        PJM = (FHP, SPX)
        SMJ = (KQD, KQD)
        XGC = (CMM, PHF)
        PDJ = (QCK, MHB)
        SPN = (MTT, XTV)
        BPK = (KFP, SPH)
        MVF = (NQC, NKK)
        LJB = (LBH, LBH)
        GQN = (QCK, MHB)
        NCG = (MTP, PXG)
        GQL = (VGT, DTP)
        NCX = (FNH, SHD)
        HGZ = (QRS, SMR)
        GMJ = (VSF, SFJ)
        RFP = (XLP, RBD)
        TXF = (GDC, HKP)
        NBA = (SMR, QRS)
        QTB = (FRL, NCX)
        QLC = (GDN, QMD)
        QHV = (SVV, HRM)
        XTM = (GRV, THT)
        VPN = (HHN, LTT)
        RFZ = (XLR, QKM)
        CMH = (SXG, CLF)
        GFJ = (TCX, PHG)
        VTT = (LGM, LFV)
        RTC = (GKH, KPS)
        XFJ = (VTQ, SDN)
        GCX = (PGB, MJD)
        MJK = (CLP, VML)
        QQL = (RSG, KTG)
        NSB = (XHQ, MGQ)
        HCQ = (LGM, LFV)
        GQX = (GJD, XKT)
        RVR = (VVK, BKP)
        JBG = (KKS, VBH)
        JFF = (BTV, BTV)
        BPM = (LNT, KPK)
        LNQ = (JJR, HGQ)
        FKK = (GLH, GPQ)
        SBL = (CDK, BGL)
        LNT = (BNH, RNS)
        JRH = (JPS, HFG)
        VVS = (MJD, PGB)
        DPP = (LFR, GFQ)
        MNF = (PBP, VDN)
        QKM = (DSM, MJK)
        JPJ = (CXN, RTJ)
        QGC = (RQP, LBX)
        CVB = (MND, RCV)
        RFC = (CHG, FFQ)
        KPS = (BCF, VSD)
        XML = (MNV, TXG)
        JVH = (JDP, GGF)
        CRC = (XTM, LLQ)
        VJG = (JRH, LLT)
        SPB = (JPT, NDM)
        JGV = (XKX, DNF)
        GGQ = (XXQ, JKD)
        XLK = (PGQ, VKB)
        JBX = (NNX, VRP)
        RSG = (HNR, GGQ)
        GVC = (LCT, XNM)
        XDP = (XML, HND)
        CXC = (SMQ, NGK)
        PXV = (TNK, BPG)
        NDM = (XCR, GQX)
        CPM = (BJH, QXK)
        KGK = (LKX, SPS)
        BLT = (NRL, PQR)
        BHN = (GLH, GPQ)
        BLS = (TKL, MNF)
        PHL = (CDK, BGL)
        BCX = (DFF, DBX)
        HNH = (GKQ, VJG)
        VKD = (NCM, TCF)
        DSM = (VML, CLP)
        DNN = (SLT, KJD)
        SBR = (SKT, JCC)
        TNL = (BGR, CJD)
        DFT = (XFL, JDG)
        MPT = (RKT, MFF)
        TVQ = (XDP, QBP)
        LLT = (JPS, HFG)
        DXQ = (XTM, LLQ)
        SFM = (PHG, TCX)
        BNJ = (MND, RCV)
        PBS = (NHQ, QRB)
        JXM = (HRF, PKB)
        VTP = (HPT, GTX)
        SVV = (XXJ, RHB)
        MHA = (QQJ, BFC)
        MBV = (HMQ, MCS)
        VJJ = (BLT, PNM)
        QJT = (RVR, CGR)
        VVN = (LXS, KTC)
        QKS = (TRC, DFM)
        MGQ = (MBS, SJB)
        NDL = (BPT, KRN)
        JPQ = (SVF, HDT)
        VDH = (JHR, GCQ)
        KCQ = (KNJ, KNJ)
        XJJ = (DFT, SBG)
        JQV = (MPV, KLR)
        VQD = (DXQ, CRC)
        JDG = (TJK, QMH)
        SPX = (XCF, PPD)
        LXJ = (TNV, BFM)
        LBL = (NGQ, JHN)
        QBN = (QQL, JPP)
        LFS = (CVB, BNJ)
        LBS = (JFV, NKC)
        TLL = (THM, GNR)
        """.trimIndent()
}
