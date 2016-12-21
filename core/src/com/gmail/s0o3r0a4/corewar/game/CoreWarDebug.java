package com.gmail.s0o3r0a4.corewar.game;

import java.util.ArrayList;

import static com.gmail.s0o3r0a4.corewar.core.Instruction.ADDR_MODE.DIR;
import static com.gmail.s0o3r0a4.corewar.core.Instruction.ADDR_MODE.IMM;
import static com.gmail.s0o3r0a4.corewar.core.Instruction.ADDR_MODE.IND;
import static com.gmail.s0o3r0a4.corewar.core.Instruction.MODIFIER.F;
import static com.gmail.s0o3r0a4.corewar.core.Instruction.MODIFIER.AB;
import static com.gmail.s0o3r0a4.corewar.core.Instruction.MODIFIER.I;
import static com.gmail.s0o3r0a4.corewar.core.Instruction.OP_CODE.DAT;
import static com.gmail.s0o3r0a4.corewar.core.Instruction.OP_CODE.MOV;
import static com.gmail.s0o3r0a4.corewar.core.Instruction.OP_CODE.ADD;
import static com.gmail.s0o3r0a4.corewar.core.Instruction.OP_CODE.JMP;

import com.gmail.s0o3r0a4.corewar.core.Instruction;
import com.gmail.s0o3r0a4.corewar.core.Process;
import com.gmail.s0o3r0a4.corewar.core.Warrior;

public class CoreWarDebug extends CoreWar
{
//    private int coreSize;
//    private Instruction core[];
//    private ArrayList<Warrior> warriors = new ArrayList<Warrior>();
//    private ArrayList<Instruction> warriorsCode[];
//
//    private Process currentProcess;
//
//    private int warriorID;
//    private int maxWarrior;

    private static final Instruction DAT00 = new Instruction(DAT, F, DIR, 0, DIR, 0);

    @Override
    public void cycle()
    {
        super.cycle();
    }

    @Override
    protected void removeWarrior()
    {
        super.removeWarrior();
        // TODO: Record lost warrior
    }

//    TODO:
//    TODO: mod.a 2, 1
//    TODO: dat.a -15, 0
//    TODO: dat.a 31, 1

    @Override
    public void initCore()
    {
        for (int i = 0; i < coreSize; i++)
        {
            core[i] = DAT00;
        }

        core[0] = new Instruction(ADD, AB, IMM, 4, DIR, 3);
        core[1] = new Instruction(MOV, I, DIR, 2, IND, 2);
        core[2] = new Instruction(JMP, AB, DIR, -2, DIR, 0);
        core[3] = new Instruction(DAT, F, IMM, 0, IMM, 0);

        core[81] = new Instruction(MOV, I, DIR, 0, DIR, 1);

        warriorID = 0;
        maxWarrior = 2;

        Warrior warrior = new Warrior(0, coreSize);
        // README: Except first one Minus one (temp)
        // TODO: Clean up this restriction
        Warrior warrior2 = new Warrior(81 - 1, coreSize);
        warriors.add(warrior);
        warriors.add(warrior2);
        currentProcess = warrior.getProcess();
        currentProcess.setAddr(0);
    }

    public Instruction.OP_CODE getType(int address)
    {
        return getInstruction(address).getOpCode();
    }

    public int getCoreSize()
    {
        return coreSize;
    }

    public boolean isUnempty(int i)
    {
        if (core[i].getFieldA() != 0 || core[i].getFieldB() != 0)
        {
            return true;
        } else
        {
            return false;
        }
    }

    public CoreWarDebug(int coreSize)
    {
        super(coreSize);
        this.currentProcess = new Process(0, coreSize); // TODO: Add new constructor

        this.warriors = new ArrayList<Warrior>();
        initCore();
    }

    public void run()
    {
        initCore();

        for (int step = 0; step < 10; step++)
        {
            if (maxWarrior > 0)
            {
                cycle();
            }
        }
//        for(int i = 0; i < 125; i++)
//        {
//            String sentence = "";
//            for(int j = 0; j < 16; j++)
//            {
//                Gdx.app.log("", core[j].getOpCode().toString()+"."+core[j].getModifier().toString()+
//                                " "+core[j].getModeA().toString()+Integer.toString(core[j].getFieldA())+
//                                " "+core[j].getModeB().toString()+Integer.toString(core[j].getFieldB()));
//                if (core[j].getOpCode() == DAT)
//                {
//                    sentence += ".";
//                }
//                else if ((core[j].getOpCode() == MOV) && (currentProcess.getAddr() == j))
//                {
//                    sentence += "M";
//                }
//                else
//                {
//                    sentence += "m";
//                }
    }
//            Gdx.app.log("", sentence);
//        }
//    }
}
