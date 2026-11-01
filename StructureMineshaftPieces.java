import java.util.List;
import java.util.Random;

public class StructureMineshaftPieces {
   private static final fx[] a = new fx[]{
      new fx(Item.o.bQ, 0, 1, 5, 10),
      new fx(Item.p.bQ, 0, 1, 3, 5),
      new fx(Item.aC.bQ, 0, 4, 9, 5),
      new fx(Item.aW.bQ, 4, 4, 9, 5),
      new fx(Item.n.bQ, 0, 1, 2, 3),
      new fx(Item.m.bQ, 0, 3, 8, 10),
      new fx(Item.U.bQ, 0, 1, 3, 15),
      new fx(Item.g.bQ, 0, 1, 1, 1),
      new fx(Block.aG.bO, 0, 4, 8, 1),
      new fx(Item.ItemShears.bQ, 0, 2, 4, 10),
      new fx(Item.bg.bQ, 0, 2, 4, 10)
   };

   private static StructureComponent getRandomComponent(List par0List, Random par1Random, long par2, int par3, long par4, int par5, int par6) {
      int i = par1Random.nextInt(100);
      if (i >= 80) {
         StructureBoundingBox structureboundingbox = ComponentMineshaftCross.findValidPlacement(par0List, par1Random, par2, par3, par4, par5);
         if (structureboundingbox != null) {
            return new ComponentMineshaftCross(par6, par1Random, structureboundingbox, par5);
         }
      } else if (i >= 70) {
         StructureBoundingBox structureboundingbox1 = ComponentMineshaftStairs.findValidPlacement(par0List, par1Random, par2, par3, par4, par5);
         if (structureboundingbox1 != null) {
            return new ComponentMineshaftStairs(par6, par1Random, structureboundingbox1, par5);
         }
      } else {
         StructureBoundingBox structureboundingbox2 = ComponentMineshaftCorridor.findValidPlacement(par0List, par1Random, par2, par3, par4, par5);
         if (structureboundingbox2 != null) {
            return new ComponentMineshaftCorridor(par6, par1Random, structureboundingbox2, par5);
         }
      }

      return null;
   }

   private static StructureComponent getNextMineShaftComponent(StructureComponent par0StructureComponent, List par1List, Random par2Random, long par3, int par4, long par5, int par6, int par7) {
      if (par7 > 8) {
         return null;
      }

      if (Math.abs(par3 - par0StructureComponent.b().a) <= 80L && Math.abs(par5 - par0StructureComponent.b().c) <= 80L) {
         StructureComponent structurecomponent = getRandomComponent(par1List, par2Random, par3, par4, par5, par6, par7 + 1);
         if (structurecomponent != null) {
            par1List.add(structurecomponent);
            structurecomponent.a(par0StructureComponent, par1List, par2Random);
         }

         return structurecomponent;
      } else {
         return null;
      }
   }

   static StructureComponent getNextComponent(StructureComponent par0StructureComponent, List par1List, Random par2Random, long par3, int par4, long par5, int par6, int par7) {
      return getNextMineShaftComponent(par0StructureComponent, par1List, par2Random, par3, par4, par5, par6, par7);
   }

   static fx[] a() {
      return a;
   }
}
