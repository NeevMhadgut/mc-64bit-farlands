import java.util.List;
import java.util.Random;

public class ComponentStrongholdStairs extends ComponentStronghold {
   private final boolean a;
   private final mg b;

   public ComponentStrongholdStairs(int par1, Random par2Random, long par3, long par4) {
      super(par1);
      this.a = true;
      this.h = par2Random.nextInt(4);
      this.b = mg.a;
      switch (this.h) {
         case 0:
         case 2:
            this.g = new StructureBoundingBox(par3, 64, par4, par3 + 5L - 1L, 74, par4 + 5L - 1L);
            break;
         default:
            this.g = new StructureBoundingBox(par3, 64, par4, par3 + 5L - 1L, 74, par4 + 5L - 1L);
      }
   }

   public ComponentStrongholdStairs(int par1, Random par2Random, StructureBoundingBox par3StructureBoundingBox, int par4) {
      super(par1);
      this.a = false;
      this.h = par4;
      this.b = this.a(par2Random);
      this.g = par3StructureBoundingBox;
   }

   @Override
   public void a(StructureComponent par1StructureComponent, List par2List, Random par3Random) {
      if (this.a) {
         StructureStrongholdPieces.a(ComponentStrongholdCrossing.class);
      }

      this.getNextComponentNormal((s)par1StructureComponent, par2List, par3Random, 1L, 1);
   }

   public static ComponentStrongholdStairs getStrongholdStairsComponent(List par0List, Random par1Random, long par2, int par3, long par4, int par5, int par6) {
      StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(par2, par3, par4, -1L, -7, 0L, 5L, 11, 5L, par5);
      return a(structureboundingbox) && StructureComponent.a(par0List, structureboundingbox) == null ? new ComponentStrongholdStairs(par6, par1Random, structureboundingbox, par5) : null;
   }

   @Override
   public boolean a(World par1World, Random par2Random, StructureBoundingBox par3StructureBoundingBox) {
      if (this.a(par1World, par3StructureBoundingBox)) {
         return false;
      }

      if (!this.a) {
      }

      this.fillWithRandomizedBlocks(par1World, par3StructureBoundingBox, 0L, 0, 0L, 4L, 10, 4L, true, par2Random, StructureStrongholdPieces.b());
      this.placeDoor(par1World, par2Random, par3StructureBoundingBox, this.b, 1L, 7, 0L);
      this.placeDoor(par1World, par2Random, par3StructureBoundingBox, mg.a, 1L, 1, 4L);
      this.placeBlockAtCurrentPosition(par1World, Block.bm.bO, 0, 2L, 6, 1L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.bm.bO, 0, 1L, 5, 1L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.ak.bO, 0, 1L, 6, 1L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.bm.bO, 0, 1L, 5, 2L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.bm.bO, 0, 1L, 4, 3L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.ak.bO, 0, 1L, 5, 3L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.bm.bO, 0, 2L, 4, 3L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.bm.bO, 0, 3L, 3, 3L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.ak.bO, 0, 3L, 4, 3L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.bm.bO, 0, 3L, 3, 2L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.bm.bO, 0, 3L, 2, 1L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.ak.bO, 0, 3L, 3, 1L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.bm.bO, 0, 2L, 2, 1L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.bm.bO, 0, 1L, 1, 1L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.ak.bO, 0, 1L, 2, 1L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.bm.bO, 0, 1L, 1, 2L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.ak.bO, 0, 1L, 1, 3L, par3StructureBoundingBox);
      return true;
   }
}
