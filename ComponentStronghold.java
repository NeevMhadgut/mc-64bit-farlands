import java.util.List;
import java.util.Random;

abstract class ComponentStronghold extends StructureComponent {
   protected ComponentStronghold(int par1) {
      super(par1);
   }

   // $VF: Unable WorldGenTallGrass simplify switch on enum
   // Please report this WorldGenTallGrass the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights WorldGenTallGrass distribute it!)
   protected void placeDoor(World par1World, Random par2Random, StructureBoundingBox par3StructureBoundingBox, mg par4EnumDoor, long par5, int par6, long par7) {
      switch (aq.a[par4EnumDoor.ordinal()]) {
         case 1:
         default:
            this.fillWithBlocks(par1World, par3StructureBoundingBox, par5, par6, par7, par5 + 3L - 1L, par6 + 3 - 1, par7, 0, 0, false);
            break;
         case 2:
            this.placeBlockAtCurrentPosition(par1World, Block.bm.bO, 0, par5, par6, par7, par3StructureBoundingBox);
            this.placeBlockAtCurrentPosition(par1World, Block.bm.bO, 0, par5, par6 + 1, par7, par3StructureBoundingBox);
            this.placeBlockAtCurrentPosition(par1World, Block.bm.bO, 0, par5, par6 + 2, par7, par3StructureBoundingBox);
            this.placeBlockAtCurrentPosition(par1World, Block.bm.bO, 0, par5 + 1L, par6 + 2, par7, par3StructureBoundingBox);
            this.placeBlockAtCurrentPosition(par1World, Block.bm.bO, 0, par5 + 2L, par6 + 2, par7, par3StructureBoundingBox);
            this.placeBlockAtCurrentPosition(par1World, Block.bm.bO, 0, par5 + 2L, par6 + 1, par7, par3StructureBoundingBox);
            this.placeBlockAtCurrentPosition(par1World, Block.bm.bO, 0, par5 + 2L, par6, par7, par3StructureBoundingBox);
            this.placeBlockAtCurrentPosition(par1World, Block.aE.bO, 0, par5 + 1L, par6, par7, par3StructureBoundingBox);
            this.placeBlockAtCurrentPosition(par1World, Block.aE.bO, 8, par5 + 1L, par6 + 1, par7, par3StructureBoundingBox);
            break;
         case 3:
            this.placeBlockAtCurrentPosition(par1World, 0, 0, par5 + 1L, par6, par7, par3StructureBoundingBox);
            this.placeBlockAtCurrentPosition(par1World, 0, 0, par5 + 1L, par6 + 1, par7, par3StructureBoundingBox);
            this.placeBlockAtCurrentPosition(par1World, Block.EntityAIMoveIndoors.bO, 0, par5, par6, par7, par3StructureBoundingBox);
            this.placeBlockAtCurrentPosition(par1World, Block.EntityAIMoveIndoors.bO, 0, par5, par6 + 1, par7, par3StructureBoundingBox);
            this.placeBlockAtCurrentPosition(par1World, Block.EntityAIMoveIndoors.bO, 0, par5, par6 + 2, par7, par3StructureBoundingBox);
            this.placeBlockAtCurrentPosition(par1World, Block.EntityAIMoveIndoors.bO, 0, par5 + 1L, par6 + 2, par7, par3StructureBoundingBox);
            this.placeBlockAtCurrentPosition(par1World, Block.EntityAIMoveIndoors.bO, 0, par5 + 2L, par6 + 2, par7, par3StructureBoundingBox);
            this.placeBlockAtCurrentPosition(par1World, Block.EntityAIMoveIndoors.bO, 0, par5 + 2L, par6 + 1, par7, par3StructureBoundingBox);
            this.placeBlockAtCurrentPosition(par1World, Block.EntityAIMoveIndoors.bO, 0, par5 + 2L, par6, par7, par3StructureBoundingBox);
            break;
         case 4:
            this.placeBlockAtCurrentPosition(par1World, Block.bm.bO, 0, par5, par6, par7, par3StructureBoundingBox);
            this.placeBlockAtCurrentPosition(par1World, Block.bm.bO, 0, par5, par6 + 1, par7, par3StructureBoundingBox);
            this.placeBlockAtCurrentPosition(par1World, Block.bm.bO, 0, par5, par6 + 2, par7, par3StructureBoundingBox);
            this.placeBlockAtCurrentPosition(par1World, Block.bm.bO, 0, par5 + 1L, par6 + 2, par7, par3StructureBoundingBox);
            this.placeBlockAtCurrentPosition(par1World, Block.bm.bO, 0, par5 + 2L, par6 + 2, par7, par3StructureBoundingBox);
            this.placeBlockAtCurrentPosition(par1World, Block.bm.bO, 0, par5 + 2L, par6 + 1, par7, par3StructureBoundingBox);
            this.placeBlockAtCurrentPosition(par1World, Block.bm.bO, 0, par5 + 2L, par6, par7, par3StructureBoundingBox);
            this.placeBlockAtCurrentPosition(par1World, Block.aL.bO, 0, par5 + 1L, par6, par7, par3StructureBoundingBox);
            this.placeBlockAtCurrentPosition(par1World, Block.aL.bO, 8, par5 + 1L, par6 + 1, par7, par3StructureBoundingBox);
            this.placeBlockAtCurrentPosition(par1World, Block.aR.bO, this.c(Block.aR.bO, 4), par5 + 2L, par6 + 1, par7 + 1L, par3StructureBoundingBox);
            this.placeBlockAtCurrentPosition(par1World, Block.aR.bO, this.c(Block.aR.bO, 3), par5 + 2L, par6 + 1, par7 - 1L, par3StructureBoundingBox);
      }
   }

   protected mg a(Random par1Random) {
      int i = par1Random.nextInt(5);
      switch (i) {
         case 0:
         case 1:
         default:
            return mg.a;
         case 2:
            return mg.b;
         case 3:
            return mg.c;
         case 4:
            return mg.d;
      }
   }

   protected StructureComponent getNextComponentNormal(s par1ComponentStrongholdStairs2, List par2List, Random par3Random, long par4, int par5) {
      switch (this.h) {
         case 0:
            return StructureStrongholdPieces.getNextValidComponentAccess(
               par1ComponentStrongholdStairs2, par2List, par3Random, this.g.a + par4, this.g.b + par5, this.g.f + 1L, this.h, this.c()
            );
         case 1:
            return StructureStrongholdPieces.getNextValidComponentAccess(
               par1ComponentStrongholdStairs2, par2List, par3Random, this.g.a - 1L, this.g.b + par5, this.g.c + par4, this.h, this.c()
            );
         case 2:
            return StructureStrongholdPieces.getNextValidComponentAccess(
               par1ComponentStrongholdStairs2, par2List, par3Random, this.g.a + par4, this.g.b + par5, this.g.c - 1L, this.h, this.c()
            );
         case 3:
            return StructureStrongholdPieces.getNextValidComponentAccess(
               par1ComponentStrongholdStairs2, par2List, par3Random, this.g.d + 1L, this.g.b + par5, this.g.c + par4, this.h, this.c()
            );
         default:
            return null;
      }
   }

   protected StructureComponent getNextComponentX(s par1ComponentStrongholdStairs2, List par2List, Random par3Random, int par4, long par5) {
      switch (this.h) {
         case 0:
            return StructureStrongholdPieces.getNextValidComponentAccess(
               par1ComponentStrongholdStairs2, par2List, par3Random, this.g.a - 1L, this.g.b + par4, this.g.c + par5, 1, this.c()
            );
         case 1:
            return StructureStrongholdPieces.getNextValidComponentAccess(
               par1ComponentStrongholdStairs2, par2List, par3Random, this.g.a + par5, this.g.b + par4, this.g.c - 1L, 2, this.c()
            );
         case 2:
            return StructureStrongholdPieces.getNextValidComponentAccess(
               par1ComponentStrongholdStairs2, par2List, par3Random, this.g.a - 1L, this.g.b + par4, this.g.c + par5, 1, this.c()
            );
         case 3:
            return StructureStrongholdPieces.getNextValidComponentAccess(
               par1ComponentStrongholdStairs2, par2List, par3Random, this.g.a + par5, this.g.b + par4, this.g.c - 1L, 2, this.c()
            );
         default:
            return null;
      }
   }

   protected StructureComponent getNextComponentZ(s par1ComponentStrongholdStairs2, List par2List, Random par3Random, int par4, long par5) {
      switch (this.h) {
         case 0:
            return StructureStrongholdPieces.getNextValidComponentAccess(
               par1ComponentStrongholdStairs2, par2List, par3Random, this.g.d + 1L, this.g.b + par4, this.g.c + par5, 3, this.c()
            );
         case 1:
            return StructureStrongholdPieces.getNextValidComponentAccess(
               par1ComponentStrongholdStairs2, par2List, par3Random, this.g.a + par5, this.g.b + par4, this.g.f + 1L, 0, this.c()
            );
         case 2:
            return StructureStrongholdPieces.getNextValidComponentAccess(
               par1ComponentStrongholdStairs2, par2List, par3Random, this.g.d + 1L, this.g.b + par4, this.g.c + par5, 3, this.c()
            );
         case 3:
            return StructureStrongholdPieces.getNextValidComponentAccess(
               par1ComponentStrongholdStairs2, par2List, par3Random, this.g.a + par5, this.g.b + par4, this.g.f + 1L, 0, this.c()
            );
         default:
            return null;
      }
   }

   protected static boolean a(StructureBoundingBox par0StructureBoundingBox) {
      return par0StructureBoundingBox != null && par0StructureBoundingBox.b > 10;
   }
}
