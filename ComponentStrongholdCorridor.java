import java.util.List;
import java.util.Random;

public class ComponentStrongholdCorridor extends ComponentStronghold {
   private final int a;

   public ComponentStrongholdCorridor(int par1, Random par2Random, StructureBoundingBox par3StructureBoundingBox, int par4) {
      super(par1);
      this.h = par4;
      this.g = par3StructureBoundingBox;
      this.a = par4 != 2 && par4 != 0 ? par3StructureBoundingBox.b() : par3StructureBoundingBox.d();
   }

   @Override
   public void a(StructureComponent structurecomponent, List list, Random random) {
   }

   public static StructureBoundingBox func_35051_a(List par0List, Random par1Random, long par2, int par3, long par4, int par5) {
      StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(par2, par3, par4, -1L, -1, 0L, 5L, 5, 4L, par5);
      StructureComponent structurecomponent = StructureComponent.a(par0List, structureboundingbox);
      if (structurecomponent == null) {
         return null;
      }

      if (structurecomponent.b().b == structureboundingbox.b) {
         for (int i = 3; i >= 1; i--) {
            StructureBoundingBox structureboundingbox1 = StructureBoundingBox.getComponentToAddBoundingBox(par2, par3, par4, -1L, -1, 0L, 5L, 5, i - 1, par5);
            if (!structurecomponent.b().a(structureboundingbox1)) {
               return StructureBoundingBox.getComponentToAddBoundingBox(par2, par3, par4, -1L, -1, 0L, 5L, 5, i, par5);
            }
         }
      }

      return null;
   }

   @Override
   public boolean a(World par1World, Random par2Random, StructureBoundingBox par3StructureBoundingBox) {
      if (this.a(par1World, par3StructureBoundingBox)) {
         return false;
      }

      for (int i = 0; i < this.a; i++) {
         this.placeBlockAtCurrentPosition(par1World, Block.bm.bO, 0, 0L, 0, i, par3StructureBoundingBox);
         this.placeBlockAtCurrentPosition(par1World, Block.bm.bO, 0, 1L, 0, i, par3StructureBoundingBox);
         this.placeBlockAtCurrentPosition(par1World, Block.bm.bO, 0, 2L, 0, i, par3StructureBoundingBox);
         this.placeBlockAtCurrentPosition(par1World, Block.bm.bO, 0, 3L, 0, i, par3StructureBoundingBox);
         this.placeBlockAtCurrentPosition(par1World, Block.bm.bO, 0, 4L, 0, i, par3StructureBoundingBox);

         for (int j = 1; j <= 3; j++) {
            this.placeBlockAtCurrentPosition(par1World, Block.bm.bO, 0, 0L, j, i, par3StructureBoundingBox);
            this.placeBlockAtCurrentPosition(par1World, 0, 0, 1L, j, i, par3StructureBoundingBox);
            this.placeBlockAtCurrentPosition(par1World, 0, 0, 2L, j, i, par3StructureBoundingBox);
            this.placeBlockAtCurrentPosition(par1World, 0, 0, 3L, j, i, par3StructureBoundingBox);
            this.placeBlockAtCurrentPosition(par1World, Block.bm.bO, 0, 4L, j, i, par3StructureBoundingBox);
         }

         this.placeBlockAtCurrentPosition(par1World, Block.bm.bO, 0, 0L, 4, i, par3StructureBoundingBox);
         this.placeBlockAtCurrentPosition(par1World, Block.bm.bO, 0, 1L, 4, i, par3StructureBoundingBox);
         this.placeBlockAtCurrentPosition(par1World, Block.bm.bO, 0, 2L, 4, i, par3StructureBoundingBox);
         this.placeBlockAtCurrentPosition(par1World, Block.bm.bO, 0, 3L, 4, i, par3StructureBoundingBox);
         this.placeBlockAtCurrentPosition(par1World, Block.bm.bO, 0, 4L, 4, i, par3StructureBoundingBox);
      }

      return true;
   }
}
