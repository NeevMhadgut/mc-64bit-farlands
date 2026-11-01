import java.util.List;
import java.util.Random;

public class ComponentStrongholdStairsStraight extends ComponentStronghold {
   private final mg a;

   public ComponentStrongholdStairsStraight(int par1, Random par2Random, StructureBoundingBox par3StructureBoundingBox, int par4) {
      super(par1);
      this.h = par4;
      this.a = this.a(par2Random);
      this.g = par3StructureBoundingBox;
   }

   @Override
   public void a(StructureComponent par1StructureComponent, List par2List, Random par3Random) {
      this.getNextComponentNormal((s)par1StructureComponent, par2List, par3Random, 1L, 1);
   }

   public static ComponentStrongholdStairsStraight findValidPlacement(List par0List, Random par1Random, long par2, int par3, long par4, int par5, int par6) {
      StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(par2, par3, par4, -1L, -7, 0L, 5L, 11, 8L, par5);
      return a(structureboundingbox) && StructureComponent.a(par0List, structureboundingbox) == null ? new ComponentStrongholdStairsStraight(par6, par1Random, structureboundingbox, par5) : null;
   }

   @Override
   public boolean a(World par1World, Random par2Random, StructureBoundingBox par3StructureBoundingBox) {
      if (this.a(par1World, par3StructureBoundingBox)) {
         return false;
      }

      this.fillWithRandomizedBlocks(par1World, par3StructureBoundingBox, 0L, 0, 0L, 4L, 10, 7L, true, par2Random, StructureStrongholdPieces.b());
      this.placeDoor(par1World, par2Random, par3StructureBoundingBox, this.a, 1L, 7, 0L);
      this.placeDoor(par1World, par2Random, par3StructureBoundingBox, mg.a, 1L, 1, 7L);
      int i = this.c(Block.aH.bO, 2);

      for (int j = 0; j < 6; j++) {
         this.placeBlockAtCurrentPosition(par1World, Block.aH.bO, i, 1L, 6 - j, 1 + j, par3StructureBoundingBox);
         this.placeBlockAtCurrentPosition(par1World, Block.aH.bO, i, 2L, 6 - j, 1 + j, par3StructureBoundingBox);
         this.placeBlockAtCurrentPosition(par1World, Block.aH.bO, i, 3L, 6 - j, 1 + j, par3StructureBoundingBox);
         if (j < 5) {
            this.placeBlockAtCurrentPosition(par1World, Block.bm.bO, 0, 1L, 5 - j, 1 + j, par3StructureBoundingBox);
            this.placeBlockAtCurrentPosition(par1World, Block.bm.bO, 0, 2L, 5 - j, 1 + j, par3StructureBoundingBox);
            this.placeBlockAtCurrentPosition(par1World, Block.bm.bO, 0, 3L, 5 - j, 1 + j, par3StructureBoundingBox);
         }
      }

      return true;
   }
}
